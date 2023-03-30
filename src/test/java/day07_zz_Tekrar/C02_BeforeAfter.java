package day07_zz_Tekrar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before
    public void setup(){
        System.out.println("her test methodu oncesi bir kez calisir");
    }
    @After
    public void tearDown(){
        System.out.println("Her test methodu sonrasi Bir Kez Calisir");
    }

    @Test
    public void test01(){
        System.out.println("test 1 methodu");
    }
    @Test
    public void test02(){
        System.out.println("test 2 methodu");
    }
}
