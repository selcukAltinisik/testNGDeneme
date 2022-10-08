package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;
public class HerokuTestPage {
    public HerokuTestPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//button[@id='onblur']")
    public WebElement onblur;
    @FindBy (xpath = "//button[@id='onclick']")
    public WebElement onclick;
    @FindBy (xpath = ("//button[@id='oncontextmenu']"))
    public WebElement contextmenu;
    @FindBy (xpath = ("//button[@id='ondoubleclick']"))
    public WebElement doubleClick;
    @FindBy (xpath = ("//button[@id='onfocus']"))
    public WebElement onfocus;
    @FindBy(xpath = ("//button[@id='onkeydown']"))
    public WebElement keydown;
    @FindBy (xpath = ("//button[@id='onkeyup']"))
    public WebElement keyup;
    @FindBy (xpath = ("//button[@id='onkeypress']"))
    public WebElement keypress;
    @FindBy (xpath = ("//button[@id='onmouseover']"))
    public WebElement mouseOver;
    @FindBy (xpath = ("//button[@id='onmouseleave']"))
    public WebElement mouseLeave;
    @FindBy (xpath = ("//button[@id='onmousedown']"))
    public WebElement mouseDown;
    @FindBy (xpath = ("//*[.='Event Triggered']"))
    public List<WebElement> eventTriggered;
}