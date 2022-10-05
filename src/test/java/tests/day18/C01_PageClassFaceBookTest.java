package tests.day18;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C01_PageClassFaceBookTest {
    @Test
    public void test01() throws InterruptedException {
        //https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");

        //POM’a uygun olarak email, sifre kutularini ve giris yap
        //butonunu locate edin
        FacebookPage facebookPage = new FacebookPage();
        Faker faker = new Faker();

        //Faker class’ini kullanarak email ve sifre degerlerini
        //yazdirip, giris butonuna basin
        facebookPage.email.sendKeys(faker.internet().emailAddress());
        facebookPage.sifre.sendKeys(faker.internet().password());
        facebookPage.login.click();

        Thread.sleep(5000);
        //Basarili giris yapilamadigini test edin
        if (facebookPage.girisYapilmadi.isDisplayed()){
            Thread.sleep(1000);
            Assert.assertTrue(facebookPage.girisYapilmadi.isDisplayed());
        } else if (facebookPage.evetDevamEt.isDisplayed()) {
            Thread.sleep(3000);

            facebookPage.senDegilMisin.click();
            Thread.sleep(3000);
            Assert.assertTrue(facebookPage.girisYapilmadi.isDisplayed());

        } else if (facebookPage.sifreniMiUnuttun.isDisplayed()){
            Thread.sleep(1000);
            Assert.assertTrue(facebookPage.sifreniMiUnuttun.isDisplayed());
        }
        Driver.closeDriver();
    }
}

