package Practice;

import org.junit.*;

public class C02_Junıt {

    /*
    Junıt de testler national ordera göre calışır,
    Before class; class her çalıştıgında ilk önce bu metod çalışır ve 1 defa calışır
    After class; class her çalıştıgında en son bu metod çalışır ve 1 defa calışır
    Before; her testten önce çalışır, test sayısı kadar çalışmış olur.
    After; her testten sonra çalışır, test sayısı kadar çalışmış olur
     */


    @BeforeClass
    public static void beforeclass(){
        System.out.println("Before class");
    }

    @AfterClass
    public static void afterclass(){
        System.out.println("After class");
    }

    @Before
    public void before() {
        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @Test
    public void test01(){
        System.out.println("Test 01");
    }

    @Test
    public void test02(){
        System.out.println("Test 02");
    }

    @Test
    public void test03(){
        System.out.println("Test 03");
    }
}
