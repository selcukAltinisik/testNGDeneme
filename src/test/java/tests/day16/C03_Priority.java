package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {

    @Test   (priority = 1)
    public void youtubeTest() {
        driver.get("https://youtube.com");
    }

    @Test  //   Burayı sıfır kabul eder.
    public void bestBuyTest() {
        driver.get("https://www.bestbuy.com");
    }

    @Test   (priority = 2)
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }

    @Test   (priority = -1, groups = "gp1")
    public void hepsiburadaTesti() {
        driver.get("https://hepsiburada.com");
    }
}
