package day_10;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;

public class C01_İlkTestBaseClass extends TestBaseBeforeAfter {

    @Test
    public void test(){
        driver.get("https://amazon.com");
    }

}
