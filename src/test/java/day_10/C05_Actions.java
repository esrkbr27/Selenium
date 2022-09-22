package day_10;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_Actions extends TestBaseBeforeAfter {

    @Test

    public void test() throws InterruptedException {
/*
        Yeni bir class olusturalim: MouseActions2
        https://demoqa.com/droppable adresine gidelim
       “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
       “Drop here” yazisi yerine “Dropped!” oldugunu test edin
 */
        driver.get("   https://demoqa.com/droppable");

        /*
        Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
       “Drop here” yazisi yerine “Dropped!” oldugunu test edin*/
        WebElement dragme= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drophere=driver.findElement(By.xpath("//*[@id='droppable'][1]"));

        Actions action=new Actions(driver);
        Thread.sleep(2000);
        action.dragAndDrop(dragme, drophere).perform();

     // “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
    }
}
