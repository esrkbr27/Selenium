package day_13;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class C01_Cookies extends TestBaseBeforeAfter {
    /*
    1-Amazon anasayfaya gidin
-tum cookie’leri listeleyin
3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
6-eklediginiz cookie’nin sayfaya eklendigini test edin
7-ismi skin olan cookie’yi silin ve silindigini test edin
8-tum cookie’leri silin ve silindigini test edin
     */

    @Test
    public void test1() {
        driver.get("https://amazon.com");

       //-tum cookie’leri listeleyin
       Set<Cookie> tumcookie= driver.manage().getCookies();
        System.out.println(tumcookie);

        int sayac=1;

        for (Cookie w:tumcookie) {
            System.out.println(sayac+".ci cookie : "+ w);
            System.out.println(sayac+".ci cookie name: "+ w.getName());
            System.out.println(sayac+".ci cookie value: "+ w.getValue());
            sayac++;
        }

    //    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        int cookiessayi= tumcookie.size();
        Assert.assertTrue(cookiessayi>5);

    //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        for (Cookie w:tumcookie) {
            if(w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD", w.getValue());
            }
        }
        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);
        tumcookie = driver.manage().getCookies();
        sayac = 1;
        for (Cookie w:tumcookie) {
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". name : "+w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }
        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(tumcookie.contains(yeniCookie));
        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        sayac = 1;
        for (Cookie w:tumcookie) {
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". name : "+w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }
        Cookie isim=driver.manage().getCookieNamed("skin");
        Assert.assertFalse(tumcookie.contains(isim));

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumcookie=driver.manage().getCookies();
        Assert.assertTrue(tumcookie.isEmpty());

    //






















    }
}
