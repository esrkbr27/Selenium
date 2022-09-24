package day_14;

import Utilities.TestBaseBeforeAfter;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel  {

    @Test
    public void readexcelTest1() throws IOException {
/*
        Ara-->dosyaYolu
        Windows Gezgini ile ac-->FileInputStream
        Excel i ac-->Workbook
        Sayfa1 e git-->Sheet
        Satiri bul-->Row
        */

        //- Dosya yolunu bir String degiskene atayalim
        String dosyayolu="src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyayolu);//Oluşturdugumuz dosyayı sistemde işleme alır

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook = WorkbookFactory.create(fis);
        /*
        Workbook objesi ile fis kullanarak akışa alıdıgımız dosyamızda bir
        excel dosyası create ettık
         */

        //- WorkbookFactory.create(fileInputStream)
        //- Sheet objesi olusturun workbook.getSheetAt(index)
        /*
        Excel dosyamızda çalışmak istediğimiz sayfayı
        bu sekilde seceriz
         */
        Sheet sheet=workbook.getSheet("Sayfa1");
        //- Row objesi olusturun sheet.getRow(index)
        //Sayfa 1 dekı 3. satırı bu şekilde seceriz
        Row row=sheet.getRow(3);
        //- Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(3);
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        System.out.println(cell);
        String expectedData="Cezayir";
        String actualData= cell.toString();


        Assert.assertEquals(expectedData, actualData);
    }
}
