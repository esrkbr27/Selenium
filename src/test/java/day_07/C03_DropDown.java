package day_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
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

    WebDriver driver;
    Select select;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown(){
    //    driver.close();
    }

    @Test
    public void test1(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        //oldugunu testedin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
         select=new Select(ddm);
        /*
        Dropdown menüye ulaşmak için select classından bir obje oluştururuz
        ve locate ettiğimiz dropdown web elementini select classına tanımlarız
        ve getOptions() metodunu kullanarak dropdownu bir liste atarak dropdown menünün
        bütün elemanlarının sayısına ulaşabiliriz
         */
        List<WebElement> ddmlist=select.getOptions();
        System.out.println(ddmlist.size());
        int expectedsayi=45;
        int actuaqlsayi= ddmlist.size();
        Assert.assertNotEquals(expectedsayi,actuaqlsayi);
    }

    @Test
    public void test2(){
    //1.Kategori menusunden Books seceneginisecin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select= new Select(ddm);

        /*
        Eger dropdown menudekı optiona string kullanarak
        ulaşmak istiyorsak "selectByVisibleText" metodu ile
        index ile ulaşmak istersek;selectByIndex
        books optionının valu degeri ile almak istersk: selectByValue
        metotları kullanılır
         */
        select.selectByVisibleText("Books");
             /*
        Dropdown menüde sectiğimiz optiona ulaşmak istersek
        select.getFirstSelectedOption(). metodunu kullanırız
         */
        System.out.println(select.getFirstSelectedOption().getText());
   //     select.selectByIndex(5);
   //     select.selectByValue("search-alias=stripbooks-intl-ship");

     //2.Arama kutusuna Java yazin vearatin
        driver.findElement(By.id("twotabsearchboxd")).sendKeys("Java", Keys.ENTER);

    //3.Bulunan sonuc sayisiniyazdirin
        String sonucyazisi=driver.findElement(By.xpath("//*[text()='1-24 of over 6,000 results for']")).getText();
    //    4.Sonucun Java kelimesini icerdigini testedin
        Assert.assertTrue(sonucyazisi.contains("Java"));

        /*
        Dropdown menüde sectiğimiz optiona ulaşmak istersek
        select.getFirstSelectedOption(). metodunu kullanırız
         */
        System.out.println(select.getFirstSelectedOption().getText());

    }

}
