package day_11;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExists extends TestBaseBeforeAfter {

    @Test
    public void Test1() {
        /*
        Tests packagenin altina bir class oluşturalim : C04_FileDownload
        Iki tane metod oluşturun : isExist( ) ve downloadTest( )
        downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
        https://the-internet.herokuapp.com/download adresine gidelim.
        test.txt dosyasını indirelim
        Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim*/

        driver.get(" https://the-internet.herokuapp.com/download ");
        //test.txt dosyasını indirelim
        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        driver.findElement(By.xpath("//*[text()='Test.txt']")).click();

        String dosyayolu="C:\\Users\\Asus\\Downloads\\Test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));

       //indirildiğini konsolda gösterelim
        System.out.println(Files.exists(Paths.get(dosyayolu)));
    }
}
