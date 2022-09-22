package day_11;

import Utilities.TestBaseBeforeAfter;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C03_Faker extends TestBaseBeforeAfter {
    @Test
    public void Test1() {
        /*
        "https://facebook.com"  Adresine gidin
“create new account”  butonuna basin
“firstName” giris kutusuna bir isim yazin
“surname” giris kutusuna bir soyisim yazin
“email” giris kutusuna bir email yazin
“email” onay kutusuna emaili tekrar yazin
Bir sifre girin
Tarih icin gun secin
Tarih icin ay secin
Tarih icin yil secin
Cinsiyeti secin
Kaydol butonuna basın
Sayfayi kapatin
         */
        //https://facebook.com"  Adresine gidin
        driver.get(" https://www.facebook.com ");

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

      //  “firstName” giris kutusuna bir isim yazin
        Faker faker=new Faker();
        /*Faker class;form doldurmamız gereken sitelerde defalarca
         deger üretecegimiz yerlerde bize otomatık değerler üretir.rastgele degerler almamızı saglar,
         Bu classı poom xml e ekleyerek aktif hale getiririz.
        Rastgele bir email,password almak icin de faker.internet().emailAdress()//password()
        Rastgele bir isim ve soyisim almak için de; faker.name().firstName()//lastname */


        //Tekrar email istediğinde aynı mail adresini girmesi için bir String değişkene atadık.
        String email=faker.internet().emailAddress();

        WebElement isim = driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-'][1]"));
        actions.click(isim).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).sendKeys("1234").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("4").sendKeys(Keys.TAB).sendKeys("Nisan").sendKeys(Keys.TAB).
                sendKeys("1989").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();;
    }
}
