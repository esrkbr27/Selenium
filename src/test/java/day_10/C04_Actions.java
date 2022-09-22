package day_10;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {

    @Test
    public void test() {

        /*

https://the-internet.herokuapp.com/context_menu sitesine gidelim  3- Cizili alan uzerinde sag click yapalim
Alert’te cikan yazinin “You selected a context menu” oldugunu
test edelim.
Tamam diyerek alert’i kapatalim
Elemental Selenium linkine tiklayalim
Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
         */

        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu ");

        //   3- Cizili alan uzerinde sag click yapalim
        WebElement cizilialan = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(cizilialan).perform(); //sag  click

        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String actualtext = driver.switchTo().alert().getText();
        String expectedtext = "You selected a context menu";

        Assert.assertEquals(expectedtext, actualtext);

        // 5-Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

        // 6-Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();

      //  Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        //yenı pencere acıldıgı için pencerenın handle degerlerini liste atadık
        List<String> wndwhandles=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wndwhandles.get(0));

        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText() );

    }
}