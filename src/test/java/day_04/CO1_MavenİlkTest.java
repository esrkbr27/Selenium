package day_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CO1_MavenİlkTest {
    /*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com");
        //       2- arama kutusunu locate edelim
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //       3- “Samsung headphones” ile arama yapalim
        aramakutusu.sendKeys("Samsung headphones", Keys.ENTER);
        //       4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucsayisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucsayisi.getText());
        //       5- Ilk urunu tiklayalim
        WebElement ilkresim = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        ilkresim.click();
        //       6- Sayfadaki tum basliklari yazdiralim
    }

}