package day_14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {

    @Test
    public void test1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyayolu= "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyayolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //-Turkce baskentler sutununu yazdiralim

        /*
        getLastRowNum() metodu bize excel sayfasındakı tüm satır numarasını verir
         */
        int sonsatir=workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("Satır sayısı: "+ sonsatir);

        String turkceBaskentler="";

        for (int i = 0; i <= sonsatir; i++) {
            turkceBaskentler=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turkceBaskentler);

        }

    }
}
