package day07_Junit;

import org.junit.*;

public class C04_BeforeClassAfterClass {
    /*
        beforeclass ve afterclass methodlari sadece static methodlar ile calisir
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Classtaki Tum tetlerden once bir kez calisir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Classtaki Tum testlerden sonra bir kez calisir");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan once bir kez kullanilir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodun sonra bir kez calisir");
    }

    @Test
    public void test01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("ikinci test");
    }
}
