package day_06;

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

public class C04_Assertion {

    /*
     * https://www.youtube.com adresine gidin
     * Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
     * titleTest => Sayfa başlığının “YouTube” oldugunu test edin
     * imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     * Search Box 'in erisilebilir oldugunu test edin (isEnabled())
     * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @After
    public void tearDown()  {
        //driver.close();
    }

    @Test
    public void test01()  {
    // titleTest => Sayfa başlığının “YouTube”  test edin
    String expectedTitle = "YouTube";
    String actualTitle =driver.getTitle();

    Assert.assertEquals(expectedTitle, actualTitle);

    }
    @Test
    public void test02()  {
  //imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='style-scope ytd-logo'])[1]")).isDisplayed());
    }

    @Test
    public void test03()  {
 //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchbox=driver.findElement(By.xpath("(//*[@id='search'])[1]"));
        Assert.assertTrue(searchbox.isEnabled());

    }

    @Test
    public void test4(){
       //   * wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
         String expectedTitle = "youtube";
         String actualTitle = driver.getTitle();

         Assert.assertNotEquals("wrong",expectedTitle, actualTitle);
    }
}
