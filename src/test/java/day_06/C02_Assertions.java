package day_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {
    /*
    -Amazon sayfasına gidelim
    -3 farklı test metodu oluşturalım
    -a-Url nin amazon içerdiğini test edelim
    -b title ın facebook içermediğini test edelim
    -c sol üst köşede amazon logosunun göründüğünü test edelim
     */

   static  WebDriver driver;

   /*
   Testlerimin tamamını aynı sitede yapacaksam
   url adresini BeforeClass içerisine koyarsam her testimde otomatık olarak
   url adresine gidecektir.(ben testlerimin içine url koymasam bile)
   url in facebook içerdiğini test edelim
    */


    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {
    //-a-Url nin amazon içerdiğini test edelim
     String expectedUrl = "amazon";
     String actualUrl = driver.getCurrentUrl();
     Assert.assertTrue(actualUrl.contains(expectedUrl));
    }



    @Test
    public void test2() {
      //  -b title ın facebook içermediğini test edelim
        String expectedtitle ="facebook";
        String actualtitle= driver.getTitle();
        Assert.assertFalse(actualtitle.contains(expectedtitle));

    }
    @Test
    public void test3() {
      //  -c sol üst köşede amazon logosunun göründüğünü test edelim
        WebElement logo= driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }


    public void test4(){

        String expectedUrl="www.facebook.com";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertNotEquals(expectedUrl, actualUrl);
    }




}
