package day_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_İframe {

      /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
//    ● https://the-internet.herokuapp.com/iframe adresine gidin.

        driver.get(" https://the-internet.herokuapp.com/iframe");

// ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.

        WebElement anıframeyazisi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        System.out.println(anıframeyazisi.getText());
//  ○ Text Box’a “Merhaba Dunya!” yazin.
        /*
        Frame gecmeden önce orayı locate ederim,
        sonra locate ettiğim yere gecmek için switchTo frame metodu ile gecerim
        gectikten sonra tekrar locate edip içini temizleyip gönderecegım degeri yazdık
         */
    WebElement textbox=driver.findElement(By.id("mce_0_ifr"));
    driver.switchTo().frame(textbox);
    WebElement textboxframe=driver.findElement(By.xpath("//p"));
    textboxframe.clear();;//clear yaparak text boxın içini temizledik
    Thread.sleep(2000);
    textboxframe.sendKeys("Merhaba Dunya");

  //    ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //    dogrulayin ve konsolda yazdirin

        /*
       Yukarıdakı swtich ile iframe gectikten sonra tekrar locate almak için
       öncelikle girdiğimiz iframeden çıkmamız gerekir,yoksa hata verecektir.
         */
     driver.switchTo().defaultContent();
     WebElement altyazi=driver.findElement(By.linkText("Elemental Selenium"));
     Assert.assertTrue(altyazi.isDisplayed());
        System.out.println(altyazi.getText());

    }
}