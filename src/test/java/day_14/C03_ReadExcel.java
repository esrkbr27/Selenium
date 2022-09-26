package day_14;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {

        /*
        Belirtilen satirNo ve sutunNo degerlerini parametre
        olarak alıp o celldekı datayı konsola yazdırın.
        Sonucun konsolda yazılanla aynı oldugunu doğrulayın.
         */




        int satir=12;
        int sütun=2;

        //1.Adım:Dosya yolunu al
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //2.Adım;Dosyayı akışa al
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //3.Adım;Excel kullanmak için Workbook classından obje üret
        Workbook workbook = WorkbookFactory.create(fis);

        //4.Adım;Excelde ilgili yere git
        //İndex 0 dan basladıgı için verilen degerlerden 1 cıkardık.
        String actualData=workbook.getSheet("Sayfa1").getRow(satir-1).getCell(sütun-1).toString();
        System.out.println(actualData);

        //5.Adım sonucun konssolda yazanla aynı oldugunu doğrulayın
        String expectedData="Baku";
        Assert.assertEquals(expectedData,actualData);
    }
}
