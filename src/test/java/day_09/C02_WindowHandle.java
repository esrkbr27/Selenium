package day_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {

    //Yeni bir pencere acmak çin driver.switchTo().newWindow(WindowType.WINDOW);
    //Açılan istediğim bir sayfaya dönmek için; driver.switchTo().window(gidecegimhandledegeri);
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws InterruptedException {
        driver.close();
    }

    @Test

    public void test() throws InterruptedException {
        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
//2- Url'nin amazon içerdiğini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        //yeni pencere acmak için; switchTo().newWindow(WindowType.WINDOW);
    String amazonwh=driver.getWindowHandle();
    driver.switchTo().newWindow(WindowType.WINDOW);
    driver.get("https://www.bestbuy.com");
//4- title'in BestBuy içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));
        String bestbuywh=driver.getWindowHandle();
//5- İlk sayfaya dönüp sayfada java aratalım
        //pencereler arası gecmek için driver.switchTo.window(ilksayfahandledegeri)
        driver.switchTo().window(amazonwh);
        WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("java", Keys.ENTER);
//6- Arama sonuclarının java içerdiğini test edelim
        String expectedsonuc="java";
        String actualsonuc=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(actualsonuc.contains(expectedsonuc));
//7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestbuywh);
//8- Logonun görünürlüğünü test edelim
   WebElement logo=driver.findElement(By.xpath("//*[@class='logo'][1]"));
   Assert.assertTrue(logo.isDisplayed());
//9- Sayfaları Kapatalım
        driver.quit();
    }
}
