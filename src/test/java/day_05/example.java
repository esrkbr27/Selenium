package day_05;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class example {
        /*

     2- https://www.amazon.com/ adresine gidin
     3- Browseri tam sayfa yapin
    Sayfayi “refresh” yapin
    Sayfa basliginin “Spend less” ifadesi icerdigini test edin
    Gift Cards sekmesine basin
    Birthday butonuna basin
    Best Seller bolumunden ilk urunu tiklayin  9- Gift card details’den 25 $’i secin
   10-Urun ucretinin 25$ oldugunu test edin
    10-Sayfayi kapatin*/

    WebDriver driver;
    @Before
    public void setUp() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void method() throws InterruptedException {
        // 2- https://www.amazon.com/ adresine gidin
        driver.get(" https://www.amazon.com/");
        //        3- Browseri tam sayfa yapin
        driver.manage().window().fullscreen();
        //        Sayfayi “refresh” yapin
        Thread.sleep(3000);
        driver.navigate().refresh();
        //        Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String baslık=driver.getTitle();

        if(baslık.contains("Spend less")){
            System.out.println("Baslık içeriyor");
        }
        else{
            System.out.println("Baslık içermiyor");
        }
        //        Gift Cards sekmesine basin
        driver.findElement(By.linkText("Gift Cards")).click();
        //        Birthday butonuna basin
        driver.findElement(By.xpath("//*[@alt='Birthday gift cards']")).click();
        //        Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@alt='Amazon.com eGift Card'])[1]")).click();
        //        9- Gift card details’den 25 $’i secin
        WebElement yirmibesd=driver.findElement(By.id("gc-mini-picker-amount-1"));
        yirmibesd.click();
        //        10-Urun ucretinin 25$ oldugunu test edin
        if(yirmibesd.isDisplayed()) {
            System.out.println("Test PASSED");
        }
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
