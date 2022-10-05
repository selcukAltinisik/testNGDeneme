package tests.practice07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 {

    @Test
    public void test01() throws InterruptedException {
        // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/To-Do-List/index.html");

        // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
        WebUniversityPage webUniversityPage = new WebUniversityPage();

        //  Buradaki listeyi yapılacaklar listesine tek tek manuel olarak eklemek yerine toplu olarak bir loop kullanarak gönderebilmek
        //  amacı ile biz oluşturduk.
        List<String> workList = new ArrayList<>(Arrays.asList("Kahvaltıyı hazırla", "Bulaşıkları yıka", "Bebekle ilgilen", "Çocuğunun ödevine yardım et", "Selenyum çalış", "Uyu"));

        Actions actions = new Actions(Driver.getDriver());

        for (String w : workList) {
            actions.click(webUniversityPage.addNewToDo).sendKeys(w).sendKeys(Keys.ENTER).perform();
        }
        Thread.sleep(2000);

        //  Tüm yapılacakların üzerini çiz.
        List<WebElement> toDos = webUniversityPage.toDosWebElement;
        for (WebElement w : toDos) {
            w.click();
        }
        Thread.sleep(2000);

        //  Tüm yapılacakları sil.
        List<WebElement> deleteButtons = webUniversityPage.deleteButtonsWebElement;
        for (WebElement w : deleteButtons) {
            w.click();
        }
        Thread.sleep(2000);

        //  Tüm yapılacakların silindiğini doğrulayın.
        List<WebElement> newtodos = webUniversityPage.toDosWebElement;
        Assert.assertEquals(0, newtodos.size());

        Thread.sleep(2000);

        Driver.getDriver().close();
    }

}
