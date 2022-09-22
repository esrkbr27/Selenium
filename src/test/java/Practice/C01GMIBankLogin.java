package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01GMIBankLogin {

    public static void main(String[] args) {
      //https://www.gmibank.com/ adresine gidiniz

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gmibank.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     //   driver.close();


      //Signın butununa tıklayın
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();
        driver.findElement(By.xpath("//span[text()='Sign in']")).click();

    //// 3) Username: Batch81, Password: Batch81+ giriniz

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Batch81");
        driver.findElement(By.cssSelector("#password")).sendKeys("Batch81+"+ Keys.ENTER);
        driver.close();;
    }
}
