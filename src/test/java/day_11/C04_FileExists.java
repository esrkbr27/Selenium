package day_11;

import Utilities.TestBaseBeforeAfter;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        /*
        Bir web sitesinden indirdiğimiz ya da window içinde oluşturdugumuz
        dosyanın indiğini ya da orda oldugunu test edebilmem için o dosyanın
        üzerine Shıft tusuna basılı olarak sag click yapıp dosyanın yolunu kopyalayıp
        bir String değişkene atarız ve dosyayı doğrulamak için
        " Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));" bu metodu kullanırız.
         */


        String dosyayolu="C:\\Users\\Asus\\Desktop\\Untitled.txt";
        System.out.println(Files.exists(Paths.get(dosyayolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));
    }
}
