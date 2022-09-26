package day_14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void test1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyayolu="src/resources/ulkeler.xlsx";

//-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyayolu);

//-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
// -WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

//-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin

        //Excel de kullanılan satir(içinde veri olan satırların) sayisini
        // getPhysicalNumberOfRows() metodu ile bulabiliriz
        // tablodakı son satırı ise getLastRowNum() metodu ile bulabiliriz
        //içinde veri olan veya olmayan son veri girilen satır numarsını verir.

        int sonsatir=  workbook.getSheet("Sayfa2").getLastRowNum();
        System.out.println(sonsatir);

        int expectedrow=6;
        Assert.assertEquals(expectedrow,sonsatir+1);

        int kullanilansatir=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println(kullanilansatir);

        int expectedkullanılansatır=4;
        Assert.assertEquals(expectedkullanılansatır,kullanilansatir);




    }


}
