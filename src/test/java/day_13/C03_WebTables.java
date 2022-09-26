package day_13;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {
    //Bir önceki class'daki adrese gidelim "https://www.hotelmycamp.com "
    //Login() methodunu kullanarak sayfaya giriş yapalım
    //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım
    //PhoneNo baslıgındakı tum numaraları yazdıralım

       /*
Tabloda<table> tagı altinda tablonun basligini gösteren <thead> tag'i bulunur.
Eger baslikta satir(row) varsa <thead> tag'i altinda <tr> (satir-row) tagi vardir.
Ve basliktaki sutunlara yani hucrelere(cell) de <th> tag' ile ulasilir.
Basligin altindaki verilere <tbody> tag'i ile altindaki satirlara(row) <tr> tag'i ile
sutunlara yani hucrelere<td> tag'i ile ulasilir.
 */




    @Test
    public void test1() {
        driver.get("https://www.hotelmycamp.com");
        log_in();
        //tablodakı 3. satir 4. sutun dakı hucreyı yazdıralım.
        int satir = 3;
        int sutun = 4;
        WebElement cell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("3. satir,4. sutundakı text: "+cell.getText());

        //PhoneNo baslıgındakı tum numaraları yazdıralım
      List< WebElement> phone=driver.findElements(By.xpath("//tbody//tr//td[6]"));
      //1. yol;
         phone.forEach(t-> System.out.println(t.getText()));

      //2. yol;
        for (WebElement w:phone) {
            System.out.println(w.getText());
        }

        List<WebElement> isimler=driver.findElements(By.xpath("//tbody//td[4]"));
        List<WebElement> mailler=driver.findElements(By.xpath("//tbody//td[3]"));

        for (int i = 0; i < isimler.size(); i++) {
            System.out.print(isimler.get(i).getText()+" -->  "+mailler.get(i).getText());
            System.out.println();
        }


        for (int i=0; i<isimler.size(); i++){
            if(isimler.get(i).getText().contains("ce")){
                System.out.println(isimler.get(i).getText()+" --->"+mailler.get(i).getText());
            }
        }



    }
    private void log_in() {
        driver.get("https://www.hotelmycamp.com ");

        WebElement login=driver.findElement(By.xpath("//*[@id='navLogon']"));
        login.click();
        WebElement username=driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(username).sendKeys("manager").sendKeys(Keys.TAB).
                sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();


    }

}
