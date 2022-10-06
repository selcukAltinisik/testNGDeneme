package tests.day23;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {

    @DataProvider
    public static Object[][] kullanicilar() {
        return new Object[][]{{"selcuk1@gmail.com", "12345"},{"selcuk2@gmail.com", "34567"},{"selcuk3@gmail.com", "56789"}};
    }

    @Test (dataProvider = "kullanicilar")
    public void test01(String userMail, String password) {

        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //login butonuna bas
        BrcPage brc = new BrcPage();
        brc.brclogin.click();

        //Data provider ile 3 farklı userEmail ve 3 farklı password girelim
        //login butonuna tiklayin
        brc.userEmail.sendKeys(userMail);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(password)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue((brc.ikinciLogin.isDisplayed()));

    }
}
