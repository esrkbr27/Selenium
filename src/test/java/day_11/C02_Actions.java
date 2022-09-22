package day_11;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class C02_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        /*
        1- https://www.facebook.com adresine gidelim
        2- Yeni hesap olustur butonuna basalim
        3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
         4- Kaydol tusuna basalim*/

        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement isim = driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-'][1]"));
        isim.sendKeys("Esra");
        actions.sendKeys(Keys.TAB).sendKeys("Demirci").
                sendKeys(Keys.TAB).sendKeys("esraakdagdemirci@gmail.com").
                sendKeys(Keys.TAB).sendKeys("esrakubra").
                sendKeys(Keys.TAB).sendKeys("1234").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("4").sendKeys(Keys.TAB).sendKeys("Nisan").sendKeys(Keys.TAB).
                sendKeys("1989").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();

        /*Ard arda veri girmemiz gereken yerlerde ACTİONS classını kullanarak
        sadece ilk yerın locatini alıp
        diger yerlere tab butonuna tıklayarak ilerleyebilir ve degerini gönderebiliriz.
         */

    }
}
