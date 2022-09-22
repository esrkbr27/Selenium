package day_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {
    /*

●https://www.amazon.com/ adresinegidin.
-Test1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
oldugunu testedin
-Test2
1.Kategori menusunden Books seceneginisecin
2.Arama kutusuna Java yazin vearatin
3.Bulunan sonuc sayisiniyazdirin
4.Sonucun Java kelimesini icerdigini testedin
*/
    static WebDriver driver;
    @BeforeClass
    public static void setUp()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @AfterClass

    public static void tearDown()  {
    //    driver.close();
    }

    @Test
    public void test1(){

        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        //oldugunu testedin
      List< WebElement> drops=driver.findElements(By.xpath("//option"));
        System.out.println(drops.size());

        for (WebElement each : drops) {
            System.out.println(each.getText());
        }

        int dropdownlist=drops.size();
        int expectedsayi=45;

        Assert.assertNotEquals(expectedsayi, dropdownlist);
    }

    @Test
    public void test2(){
     //1.Kategori menusunden Books seceneginisecin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        ddm.sendKeys("Computers");
    //2.Arama kutusuna Java yazin vearatin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
    //3.Bulunan sonuc sayisiniyazdirin
    String sonucyazisi=driver.findElement(By.xpath("//*[text()='1-24 of over 6,000 results for']")).getText();

    //4.Sonucun Java kelimesini icerdigini testedin
        Assert.assertTrue(sonucyazisi.contains("Java"));
    }
}
