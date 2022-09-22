package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class TestCase1 {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
            11. Select checkbox 'Receive special offers from our partners!'
            12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button

15. Click 'Continue' button-
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

  static  WebDriver driver;
          Select option;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() {
    //    driver.close();
    }

    @Test
    public  void test() throws InterruptedException {
        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement mainpage = driver.findElement(By.xpath("(//*[@class='col-sm-6'])[1]"));
        if (mainpage.isDisplayed()) {
            System.out.println("Home page is visible successfully");
        } else {
            System.out.println("Home page is not visible successfully");
        }

        //   4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

        //  5. Verify 'New User Signup!' is visible
        WebElement newuser = driver.findElement(By.xpath("//h2"));
      Assert.assertTrue(newuser.isDisplayed());

        //6. Enter name and email address
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("esra", Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[@name='email'])[2]")).sendKeys("hus.nht@gmail.com");
        //   7. Click 'Signup' button
        driver.findElement(By.xpath("//*[text()='Signup']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='title text-center'])[1]")).isDisplayed());

        //   9. Fill details: Title, Name, Email, Password, Date of birth

        WebElement radiobutton = driver.findElement(By.xpath("//*[@id='id_gender2']"));

        if (!radiobutton.isSelected()) {
            radiobutton.click();
        }

        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("esrakubra27");
        driver.findElement(By.xpath("//*[@id='days']")).sendKeys("27");
        driver.findElement(By.xpath("//*[@id='months']")).sendKeys("4");
        driver.findElement(By.xpath("//*[@id='years']")).sendKeys("1989");

//10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@name='newsletter']")).click();

        //      11. Select checkbox 'Receive special offers from our partners!'
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='optin']")).click();

//  12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("Esra");
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("Demirci");
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("Serbest");
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Fath mah");
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("Akşemseddin");
        WebElement country = driver.findElement(By.xpath("//*[@id='country']"));
        option = new Select(country);
        option.selectByVisibleText("India");
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Konya");
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Meram");
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("1234");
    //  13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[@type='submit'][1]")).click();
        // 14. Account Created! yazdıgını doğrulayın
        Assert.assertTrue(driver.findElement(By.linkText("ACCOUNT CREATED!")).isDisplayed());
        //15. Click 'Continue' button-
              driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
     //   16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

     // 17. Click 'Delete Account' button
       driver.findElement(By.xpath("//*[text()='Delete']")).click();


    }
}

