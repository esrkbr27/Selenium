package day_11;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C01_Actions_Tab extends TestBaseBeforeAfter {

    @Test
    public void test1() {
       /* Bir Class olusturalim KeyboardActions1
        https://www.amazon.com sayfasina gidelim
        Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        aramanin gerceklestigini test edin*/
       driver.get(" https://www.amazon.com ");
        WebElement searchbox= driver.findElement(By.id("twotabsearchtextbox"));
       Actions action=new Actions(driver);
       action.click(searchbox).sendKeys("s").
               sendKeys("a").
               sendKeys("m").
               sendKeys("s").
               sendKeys("u").
               sendKeys("n").
               sendKeys("g").
               sendKeys(" ").keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("7").sendKeys("1").
               sendKeys(Keys.ENTER).perform();

        WebElement sonuc=driver.findElement(By.xpath("//*[text()='\"samsung A71\"']"));
        Assert.assertTrue(sonuc.isDisplayed());

        //Keys.SHIFT Otomasyonda buyuk harfle yazmak için SHIFT e basma görevini yapıyor.
        //Keys.Down basılı tutar, Keys.Up bastıgımız yeri bırakır.




    }
}
