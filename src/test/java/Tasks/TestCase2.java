package Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase2 {
    /*
    Test Case 1: Register User
Test Case 2: Login User with correct email and password
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible
     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After

    public void tearDown(){
        //driver close;
    }

    @Test
    public void test(){
     //  2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

    //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='col-sm-4']")).isDisplayed());

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();

    //    5. Verify 'Login to your account' is visible
     Assert.assertTrue(driver.findElement(By.xpath("//h2")).isDisplayed());

    // 6. Enter correct email address and password
        driver.findElement(By.xpath("//*[@name='email'][1]")).sendKeys("esraakdagdemirci@gmail.com");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("esrakubra27");

     //7. Click 'login' button
     driver.findElement(By.xpath("//*[text()='Login']")).click();

    //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());

    //    9. Click 'Delete Account' button

    driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

    //    10. Verify that 'ACCOUNT DELETED!' is visible
    }
}
