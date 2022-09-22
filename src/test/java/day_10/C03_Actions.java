package day_10;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1(){
        //-Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        //-Account menüsünden create list linkine tıklayalım
        WebElement account=driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        Actions action=new Actions(driver);
           action.moveToElement(account).perform();

           //create list linkine tıklayalım
            driver.findElement(By.xpath("//*[text()='Create a List']")).click();
            /*
            Bir web sitesinde bir web elementin mouse ile açılan
            bir web elementineulaşmak istersek Actions classından action.moveToElement() metodunu
            kullanmak gerekir.Aksi takdirde html kodları arasından web elementi bulur ama ulaşamadıgı için
            ElemenetNotInteracteble exceptionı fırlatır
             */

        //
    }
}
