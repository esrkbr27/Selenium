package Practice;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class KoalaResort extends TestBaseBeforeAfter {

    @Test
    public void test() {
     driver.get("https://qa-environment.koalaresorthotels.com/");

     //Login sayfasına gidiniz
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
 WebElement login= driver.findElement(By.xpath("//*[text()='Log in']"));
 login.click();

 //Logın ekranına girdiğinizi 4 farklı web elementi kullanarak dogrulayınız.

     Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
     Assert.assertTrue(driver.findElement(By.id("btnSubmit")).isDisplayed());
     Assert.assertFalse(driver.getTitle().startsWith("Log in"));
     Assert.assertTrue(driver.getCurrentUrl().contains("Log in"));

    }
}
