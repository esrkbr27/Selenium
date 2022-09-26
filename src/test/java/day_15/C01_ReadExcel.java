package day_15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {

    @Test
    public void test1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyayolu = "src/resources/ulkeler.xlsx";

//-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyayolu);

//-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
// -WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        int sonsatır=workbook.getSheet("Sayfa1").getLastRowNum();
        //Excel tablosunun tamamını konsola yazdırın.

        //1.yol
        for (int i = 0; i <=sonsatır; i++) {
            System.out.println(workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString()+
                    ","+workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+
                    ","+workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+
                    ","+workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString());
        }

        //2.yol
        int sayi=workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <= sayi; i++) {
            for (int j = 0; j <= sayi; j++) {
                System.out.println(workbook.getSheet("Sayfa1").getRow(i).getCell(j).toString());

            }

        }

        //3.yol;

        Map<String, String> ulkelerMap=new TreeMap<>();
        int satirSayisi=workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <=satirSayisi ; i++) {
            String key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+
                    ", "+ workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+
                    ", "+ workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key, value);
        }
        System.out.println(ulkelerMap);


    }
}