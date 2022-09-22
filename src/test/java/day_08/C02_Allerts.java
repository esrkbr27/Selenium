package day_08;

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

import java.time.Duration;

public class C02_Allerts {
    /*
    Bir web sitesine girdiğimizde karsımızda bir uyarı mesajı ya da bir butona tıkladıgımızda
    bir uyarı(allert) mesajı cıkabilir.Eger bu uyarıya incele sag tık yapabiliyorsak u tür allertlere html allert denir
    ve istediğimiz locatei alabiliriz.Ama gelen uyarı kutusuna müdahale (sag tık) edemiyorsak
    bu tür allertlere jSAllert denir.js Allertlere müdahele edebilmek için (tıklamak için) ;
    driver.switchTo().alert().accept();

    iptal için          driver.switchTo().alert().dismiss();  metodu kullanılır

    allert içindeki mesajı almak için; driver.switchTo().alert().getText(); kullanılır.

    allert bizden bir metin istiyorsa;  driver.switchTo().alert().sendKeysAllert();

     */

  /*  Bir class olusturun: Alerts
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Bir metod olusturun: acceptAlert
1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
“successfuly” icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.*/

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("   https://the-internet.herokuapp.com/javascript_alerts");

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        WebElement jsAllert= driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        jsAllert.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        // “You successfully clicked an alert” oldugunu test edin.
        WebElement successfully= driver.findElement(By.xpath("//*[@id='result']"));
        Thread.sleep(2000);
        String actualmessage=successfully.getText();
        String expectedmessage="You successfully clicked an alert";

        Assert.assertEquals(expectedmessage, actualmessage);
        Assert.assertTrue(driver.getPageSource().contains("You successfully clicked an alert"));
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("   https://the-internet.herokuapp.com/javascript_alerts");
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
     WebElement sonuc=   driver.findElement(By.xpath("//*[@onclick='jsConfirm()']"));
      sonuc.click();
      //Allert üzerindeki uyraı mesajını yazdırın
        System.out.println("2.butonun allert mesajı"+driver.switchTo().alert().getText());
        Thread.sleep(3000);
      //Allert mesajında iptale bas
      driver.switchTo().alert().dismiss();

      String actualmessage= driver.findElement(By.xpath("//*[@id='result']")).getText();
      String expectedmessage="successfully";

      Assert.assertFalse(expectedmessage.contains(actualmessage));

      /*NOTT;
        Eger soru içerdiğini diyorsa Asserttrue
        Eger soru içermediğini diyorsa Assertfalse
        Eger soru ...oldugunu/esitmı diyorsa Asserequalse
        Eger soru ...olmadıgını/esitolmadıdını diyorsa AsssertNotEqualse


*/
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("   https://the-internet.herokuapp.com/javascript_alerts");
      //  3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
      //  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("ESRA DEMİRCİ");
        driver.switchTo().alert().accept();

        String actualmessage= driver.findElement(By.xpath("//*[@id='result']")).getText();
        String message="ESRA DEMİRCİ";

        Assert.assertEquals(actualmessage, message);


    }

}
