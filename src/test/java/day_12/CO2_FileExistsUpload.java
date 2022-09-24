package day_12;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class CO2_FileExistsUpload extends TestBaseBeforeAfter {
    /*
    Tests packagenin altina bir class oluşturun : C05_UploadFile
    https://the-internet.herokuapp.com/upload adresine gidelim
    chooseFile butonuna basalim
    Yuklemek istediginiz dosyayi secelim.
    Upload butonuna basalim.
     “File Uploaded!” textinin goruntulendigini test edelim.
     */

    @Test
    public void test1() {

        driver.get("https://the-internet.herokuapp.com/upload");

      //  chooseFile butonuna basalim
    WebElement dosya= driver.findElement(By.xpath("//*[@id='file-upload']"));

    /*
    "Dosya sec" butonuna direk click yapamayabilir.,çünkü windowsa
    müdahaleye direk izin vermeyebilir.Bu yüzden  "Dosya sec" butonu locate edilip
    dosya yolu Stringe atılıp direk gönderilebilir.
     */

    String dosyayolu="C:\\Users\\Asus\\Downloads\\Test.txt";

    dosya.sendKeys(dosyayolu);

      //  Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    }
}
