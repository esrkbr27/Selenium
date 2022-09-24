package day_12;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class C01_Actions extends TestBaseBeforeAfter {
    //Automationexercises.com adresine gidelim
   //product bölümüne girelim
   //ilk ürünü tıklayalım


    @Test
    public void test1() {
        driver.get("https://www.automationexercise.com");

        driver.findElement(By.xpath("//*[@href='/products']")).click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("//*[text()='View Product'][1]")).click();

    }
}
