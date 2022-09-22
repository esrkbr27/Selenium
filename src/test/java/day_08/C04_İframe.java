package day_08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_İframe {

    /*  IFrame,bir web sayfasının icine yerlestirilmis baska bir
    web sayfasıdır veya bir HTML dokumaninin içine yerleştirilmiş baskabir HTML dokumanidir.

    Bir web sitesinde bir video varsa ve <iframe> tagı içerisindeyse
    bu videoyu direk locate edip çalıştırmak dinamik olmaz
    Çünkü link değişebilir ve locatemız calışmaz.
    Bunun için bütün frameleri bir liste atıp index ile
    framei seçip sonra play tusunu locate edip çaılştırabilliriz.
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
        //driver.close();
    }

    @Test
    public void test1() {
//https://html.com/tags/iframe/ adresine gidiniz, youtube videosunu calıştırınız.

        driver.get("https://html.com/tags/iframe/");
        //sayfadakı iframe linklerinin hepsini liste attık.1. indexdeki benım aradıgım videonun linki
         List<WebElement> iframeList=driver.findElements(By.xpath("//iframe"));
         driver.switchTo().frame(iframeList.get(0));
         WebElement playbutton=driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
         playbutton.click();
    }
}
