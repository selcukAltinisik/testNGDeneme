package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBaseBeforeClassAfterClass {
    protected static WebDriver driver;
    // @BeforeClass ve @AfterClass notasyonlarını TestNG de kullanırken JUnit'teki gibi static yapmaya gerek yoktur.

    protected static String tarih;

    @BeforeClass (groups = "gp1")
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        tarih = date.format(formater);
    }

    @AfterClass (groups = "gp1")
    public void tearDown(){
        driver.close();
    }

}
