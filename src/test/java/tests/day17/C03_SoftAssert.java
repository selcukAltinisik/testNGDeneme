package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeClassAfterClass;

public class C03_SoftAssert extends TestBaseBeforeClassAfterClass {

    @Test
    public void test01() {
        SoftAssert softassert = new SoftAssert();
        //1-amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-title in Amazon içerdigini test edin
        softassert.assertTrue(driver.getTitle().contains("Amazon"),"Girdiginiz kelimeyi icermiyor");

        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softassert.assertTrue(aramaKutusu.isEnabled(),"WE erisilemez.");

        //4-arama kutusuna Nuella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //5-arama yapıldıgını test edin
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softassert.assertTrue(sonuc.isDisplayed(),"sonucWE goruntulenemedi.");

        //6-arama sonucunun Nutella içerdigini test edin
        softassert.assertTrue(sonuc.getText().contains("Nutella"),"Nutella icermiyor.");
    }
}
