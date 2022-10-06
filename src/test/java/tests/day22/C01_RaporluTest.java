package tests.day22;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {

    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Test", "Geçerli kullanıcı adı ve password ile giriş yapıldı");

        //  -https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Blue RentaCar sitesine gidildi");

        //  -login butonuna bas
        BrcPage brc = new BrcPage();
        brc.brclogin.click();
        extentTest.info("Login butonuna basıldı");
        //  -test data user email: customer@bluerentalcars.com
        brc.userEmail.sendKeys(ConfigReader.getProperty("userEmail"));
        Actions actions = new Actions(Driver.getDriver());

        //  -test data password : 12345 dataları girip login e basın
        //  -login butonuna tiklayin.
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pass")).sendKeys(Keys.TAB,Keys.ENTER).perform();

        extentTest.info("Doğru kullanıcı email ve password girildi");
        extentTest.info("İkinci login butonuna basıldı");

        //  -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String expectedUserName = "ohn Walker";
        String actualUserName = brc.basariliGiris.getText();

        Assert.assertEquals(expectedUserName,actualUserName);

        extentTest.pass("Sayfaya başarılı şekilde girildi");


    }
}
