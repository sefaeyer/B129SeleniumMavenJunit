package day20_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    @Test
    public void excelReadTest1() throws IOException {

        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        //Kullanılan satır sayısın bulun
        //Ülke-Başkent şeklinde verileri yazdırın

        //Excel dosyasindan bir veri okuyabilmemmiz icin
            //1- Dosya yolunu aliriz
            String dosyaYolu = "src/test/java/resources/Capitals.xlsx";
            //String dosyaYolu1 = "C:/Users/Sefa/Downloads/Capitals (2).xlsx";

            //2-Dosyayi okuyabilmek icin akisa almam gerekir
            FileInputStream fis = new FileInputStream(dosyaYolu);

            //3-Java ortaminda bir excel dosyasi olusturmamiz gerekir
            Workbook workbook = WorkbookFactory.create(fis);// create(fis) ile excel de bu dosyayi okuruz

            //4-Sayfayi(sheet) secmemiz gerekir
            Sheet sheet = workbook.getSheet("Sheet1");

            //5-Satir(Row) secmemiz gerekir
            Row row = sheet.getRow(0);//1. satir, cunku index 0'dan baslar.

            //6-Hucreyi(Cell) secmemiz gerekir.
            Cell cell = row.getCell(0);//1. hucre

        System.out.println("cell = " + cell);


    }


    @Test
    public void readExcelTest2() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        //1. satir 1. sutundaki bilgiyi yazdiriniz
        String satir1sutun1 = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        System.out.println(satir1sutun1);
    }

    @Test
    public void readExcelTest3() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        //1.yol
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(1);
        System.out.println("1. satir, 2. sutun: "+cell);
        //2.yol:
        System.out.println("satir 1 , sutun 2 = " + workbook.getSheet("Sheet1").getRow(0).getCell(1));

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String satir3sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("satir3sutun1 = " + satir3sutun1);

        Assert.assertEquals("France",satir3sutun1);

        //Kullanılan satır sayısıni bulun
        System.out.println("Son satir sayisi = " + workbook.getSheet("Sheet1").getLastRowNum());
        //Excel tablosundaki son satir sayisini getLastRowNum() ile aliriz
        System.out.println("Physical Number Of Satir = " + workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        //Excel tablosunda kullanilan satir sayisini getPhysicalNumberOfRows() method u ile alabiliriz

        System.out.println("getLastCellNum() = " + workbook.getSheet("Sheet1").getRow(0).getLastCellNum());
        System.out.println("getPhysicalNumberOfCells() = " + workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells());

        //Ülke-Başkent şeklinde verileri yazdırın
        //1.Yol: Map
        Map<String,String> ulkeVeBaskentler = new HashMap<>();
        for (int index = 1; index < workbook.getSheet("Sheet1").getPhysicalNumberOfRows() ; index++) {
            String ulke = workbook.getSheet("Sheet1").getRow(index).getCell(0).toString();
            String baskent = workbook.getSheet("Sheet1").getRow(index).getCell(1).toString();
            ulkeVeBaskentler.put(ulke,baskent+"\n");
        }
        System.out.println(ulkeVeBaskentler);

    }

    @Test
    public void readExcelTest4() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        //Ülke-Başkent şeklinde verileri yazdırın
        //2.Yol
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");
            }
            System.out.println();
        }
    }
}
