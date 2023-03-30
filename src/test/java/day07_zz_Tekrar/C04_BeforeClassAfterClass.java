package day07_zz_Tekrar;

import org.junit.*;

public class C04_BeforeClassAfterClass {
    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("tum testlerden once bir kez calisir");
        System.out.println("=========");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("tum testlerden SONRA bir kez calisir");
        System.out.println("=========");
    }

    @Before
    public void setUp01() throws Exception {
        System.out.println("HER testten ONCE calisir");
        System.out.println("=========");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("HER testten SONRA calisir");
        System.out.println("=========");
    }

    @Test
    public void test01() {
        System.out.println("Ilk test");
        System.out.println("=========");
    }

    @Test
    public void test02() {
        System.out.println("ikinci test");
        System.out.println("=========");
    }

    @Test
    public void test03() {
        System.out.println("ucuncu test");
        System.out.println("=========");
    }
}
