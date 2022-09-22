package day_09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandles {
    /*
      Tests package’inda yeni bir class olusturun: WindowHandle2
      https://the-internet.herokuapp.com/windows adresine gidin.
      Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
      Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
      Click Here butonuna basın.
      Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
      Sayfadaki textin “New Window” olduğunu doğrulayın.
      Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
       */
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
    //    driver.close();
    }

    @Test
    public void test(){
    //       https://the-internet.herokuapp.com/windows adresine gidin.
    driver.get("  https://the-internet.herokuapp.com/windows");
//  Sayfadaki textin “Opening a new window” olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

//Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals(driver.getTitle(), "The Internet");

//  Click Here butonuna basın.

        //Bu butona basılınca yenı bir pencere açılıyor.
   driver.findElement(By.xpath("//*[text()='Click Here']")).click();

   //     Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
      /*Acılan pencerelerin window handlellarını "getWindowHandles komutu ile alırız.Bu degerleri liste atıp,
      istediğim sayfanın handle degerini index ile alabilirim.İlk açılan pencerenın indexi 0 dir.İkinci açılan pencerede
      işlem yapmak için switchTo().window ile geçiş yapmam gerekir.
       */

        List<String> windowlists=new ArrayList<String>(driver.getWindowHandles());
        System.out.println("window handle degerleri:"+windowlists);
        driver.switchTo().window(windowlists.get(1));//iki pencere actıgımız için 0. index ilk açtıgımız,1. index yeni açtıgımız

        Assert.assertEquals(driver.getTitle(),"New Window");

   //   Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

   //   Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(windowlists.get(0));
        Assert.assertEquals("The Internet",driver.getTitle());
    }


}
