package tests.day18;

import org.testng.annotations.Test;
import utilities.Driver;

public class C02_ConfigurationProperties {

    @Test
    public void test01() {
        Driver.getDriver().get("amznUrl");
    }
}
