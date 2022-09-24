package day_12;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C04_SenkranizasyonWait extends TestBaseBeforeAfter {

    @Test
    public void isEnabledtest1() {
        /*
        1. Bir class olusturun : EnableTest
2. Bir metod olusturun : isEnabled()
3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
4. Textbox’in etkin olmadigini(enabled) dogrulayın
5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
7. Textbox’in etkin oldugunu(enabled) dogrulayın
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_controls ");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textbox = driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(textbox.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textbox));

        //    6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='It's enabled!']")).isDisplayed());

        // 7. Textbox’in etkin oldugunu(enabled) dogrulayın
        Assert.assertTrue(textbox.isEnabled());
    }

}