package day_15;

import Utilities.TestBaseBeforeAfter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBaseBeforeAfter {

    /*
    Bir web sayfanın resmini almak iin TakesScreenshot classından obje oluşturup
    gecici bir Fie classından değişkene TakesScreenshot dan oluşturduğum objeden
    getScreenshotAs() metodunu kullanarak geçici bir File oluştururuz.
     */
    @Test
    public void test1() throws IOException {
        //Amazon sayfasına gidelim,tüm sayfanın görüntüsnü alalım
        driver.get("https://www.amazon.com");
        TakesScreenshot ts= (TakesScreenshot) driver;

        File tumsayfaresmi= ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumsayfaresmi,new File("target/ekranGörüntüsü/allPage"+tarih+".jpeg"));

    }
}
