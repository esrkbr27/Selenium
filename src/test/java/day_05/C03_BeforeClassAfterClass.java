package day_05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {

    /*
    Before class notasyonu kullanıldıgında kaç tane @test notasyonu olursa olsun,
    1 defa VE İLK OLARAK @BeforeClass Notasyonu çalışır sonra  @Test notasyonları çalışır
    en sonda @AfterClass Notasyonu çalışır.

    @Before notasyonundan farkı her test için ayrı ayrı olarak çalışmaz
    ve daha az method çalışmış olur.
     */

    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
/*
Çalışmasını istemediğimiz test için ignore notasyonu kullanılır.
 */
    @Test
    public void method1() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://amazon.com");
    }

    @Test
    public void method2() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://techproeducation.com");
    }

    @Test
    public void method3() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://hepsiburada.com");
    }

}
