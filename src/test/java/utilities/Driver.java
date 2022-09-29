package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Driver {

    static WebDriver driver;
    // testlerimizi calistirdigimizda her seferinde yeni driver oludturdugu icin
    // her test methodu icin yeni bir pencere (driver) aciyor
    // eger driver'a bir deger atanmamissa yani driver == null ise
    // bir kere driver'i calistir diyerek bir kere if icini calistiracak
    // ve driver artik bir kere calistigi icin ve deger atandigi icin null olmayacak
    // ve direk return edecek ve diger testlerimiz ayni pencere (driver) uzerinde calisacak

    public static WebDriver getDriver(){

        if (driver==null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    public static void  closeDriver(){

        if (driver!=null){  //  driver'a değer atanmışsa kapat
            driver.close();
            driver=null;    //  Kapandıktan sonra sonraki açmaları garanti altına almak için driver'ı tekrar null yaptık.
        }

    }

    @Test
    public void quitDriver() {
        if (driver!=null){
            driver.quit();
            driver=null;
        }

    }
}
