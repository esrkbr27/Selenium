package day_10;

import Utilities.TestBaseBeforeClassAfterClass;
import org.junit.Test;

public class C02_İlkTestBaseBeforeClassAfterClass extends TestBaseBeforeClassAfterClass {

    @Test
    public void test(){
        driver.get("https://amazon.com");
    }
}
