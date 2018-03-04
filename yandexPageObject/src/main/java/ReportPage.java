
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class ReportPage {
    WebDriver driver;
    public ReportPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }
    @FindBys({@FindBy(xpath = ".//*[contains(@class,'link n-link_theme_blue')]")})
    private List<WebElement> allElements;

    @FindAll({  @FindBy(xpath = ".//*[contains(@class,'rrow_down button_size_s select__button i-bem')]"),
                @FindBy(xpath = ".//input[@id='header-search']")})
    private List<WebElement> buttons;
    @FindAll({  @FindBy(xpath = ".//span[text()='Показывать по 12']"),
                @FindBy(xpath = ".//input[@id='header-search']")})
    private List<WebElement> button12;

    @FindBy(xpath = ".//input[@id='header-search']")
    private WebElement input;

    public void report(){
        if(allElements.size()!=12){
            buttons.get(0).click();
            button12.get(0).click();
        }
        System.out.println(allElements.get(0).getText());
        input.sendKeys(allElements.get(0).getText());
        if(allElements.get(0).getText().equals(input.getAttribute("value"))){
            System.out.println("Наименование товара соответсвует запомненому значению");
        }
        else System.out.println("Наименование товара не соответсвует запомненому значению");
    }


}
