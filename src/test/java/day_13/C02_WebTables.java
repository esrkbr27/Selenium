package day_13;

import Utilities.TestBaseBeforeAfter;
import com.google.j2objc.annotations.Weak;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {

    @Test
    public void test1() {
        /*log in metodu oluşturun
https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
Username : manager
Password : Manager1!
table( ) metodu oluşturun
Tüm table body’sinin boyutunu(sutun sayisi) bulun.
Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
printRows( ) metodu oluşturun //tr
table body’sinde bulunan toplam satir(row) sayısını bulun.
Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
4.satirdaki(row) elementleri konsolda yazdırın.
         */

     //log in metodu oluşturun
        //https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
         log_in();
         table();


    }




    private void log_in() {
        driver.get("https://www.hotelmycamp.com ");

        WebElement login=driver.findElement(By.xpath("//*[@id='navLogon']"));
       login.click();
       WebElement username=driver.findElement(By.xpath("//*[@id='UserName']"));
       actions.click(username).sendKeys("manager").sendKeys(Keys.TAB).
               sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }

    //table( ) metodu oluşturun
    private void table() {
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        /*
Tabloda <table> tagı altında tablonun baslıgını gosteren <thead> tagı bulunur.
Eger baslikda satir(row) varsa <thead> tagı altinda <tr> (satır-row) tagı vardır.
Ve baslıkdaki sutunlara yani hucrelere(cell) de <th> tagı ile ulasilir.
Baslıgın tablodaki verilere <tbody> tagı ile altındaki satırlara(row) <tr> tagı ile sutunlara yani
hucrelere <td> tagı ile ulasilir.

table row =tr                 //thead(Baslik)         //tr(Satir)     //th(Sutun)                   Baslik icin
                              //tbody(Vucut- Ana)     //tr(Satir)      //td (Vucut - Ana Sutunu)     Body icin
table header = th
table data= td
 */
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun Sayisi = "+sutunSayisi.size());

        //Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        List<WebElement> baslıklar=driver.findElements(By.xpath("//thead//tr"));
        for (WebElement w: baslıklar) {
            System.out.println(w.getText());
        }
        //printRows( ) metodu oluşturun //tr
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlist=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodakı satir sayisi");
        satirlist.stream().forEach(t->System.out.println(t.getText()));

        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirlist.stream().forEach(t->System.out.println(t.getText()));

        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("Tablodakı 4. satır: "+ driver.findElement(By.xpath("//tbody//tr[4]")).getText());

    }



}
