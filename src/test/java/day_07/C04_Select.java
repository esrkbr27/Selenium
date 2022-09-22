package day_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_Select {
    /*
    Bir class oluşturun: DropDown
    https://the-internet.herokuapp.com/dropdown adresine gidin.
    Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Tüm dropdown değerleri(value) yazdırın
    Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.*/

    static WebDriver driver;
    static Select select;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" https://the-internet.herokuapp.com/dropdown ");
    }

    @AfterClass
    public static void tearDown(){
       // driver.close();
    }

    @Test
    public void test01(){
  // Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement aramakutusu = driver.findElement(By.xpath("//*[@id='dropdown']"));
        select=new Select(aramakutusu);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println(select.getOptions().get(1).getText());
        //  Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println(select.getOptions().get(2).getText());
    //    Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdı
        select.selectByVisibleText("Option 1");

    //Tüm dropdown değerleri(value) yazdırın
    List<WebElement> ddmlist=select.getOptions();
        for (WebElement e : ddmlist) {
            System.out.println(e.getText());
            ddmlist.forEach(t-> System.out.println(t.getText()));
     //       Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
     //       False yazdırın.*/

     int ddmboyut= ddmlist.size();
     if(ddmboyut==4){
         System.out.println("True");
     }
     else {
         System.out.println("False");
     }
               Assert.assertNotEquals(4,ddmboyut);
        }


    }


}
