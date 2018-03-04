
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchPage {
    WebDriver driver;
    Wait<WebDriver> wait;
    public SearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
        wait = new WebDriverWait(driver, 2, 4000);
    }
    @FindBy(xpath = ".//*[@data-id='market']")
    private WebElement hrefMarket;

    @FindAll({
            @FindBy(xpath = ".//*[contains(@href,'hid=198119')]"),
            @FindBy(xpath = ".//*[contains(@class,'-topmenu-new-vertical__popup-show button_size_m button_theme')]")
    })
    private List<WebElement> hrefElectronics;
    @FindAll({
            @FindBy(xpath = ".//input[@id='header-search']"),
            @FindBy(xpath = ".//*[contains(@href,'hid=198119')]")
    })
    private List<WebElement> hrefElectronics2Step;

    @FindBy(xpath = ".//*[contains(@href,'hid=198119')]")
    private WebElement hrefElectronic;

    @FindBy(xpath = ".//*[contains(@class,'n-navigation-horizontal-category i-bem')]//*[text()='Электроника']")
    private WebElement hrefElectonicsDouble;

    @FindBys({@FindBy(xpath = ".//*[contains(@class,'link catalog-menu__list-item metrika i-bem metrika')]")})
    private List<WebElement> hrefListElectronics;

    @FindBys({@FindBy(xpath = ".//*[contains(@class,'n-filter-block__body i-bem n-filter-block__body_js_inited')]//label[@class='checkbox__label']")})
    private List<WebElement> checkListProizvoditel;

    @FindBy(xpath = ".//*[contains(@name,'glf-priceto-var')]")
    private WebElement inputPriceTo;

    @FindBy(xpath = ".//*[text()='Перейти ко всем фильтрам']")
    private WebElement buttonAllFilters;

    @FindBy(xpath = ".//*[contains(@class,'button_action_show-filtered n-filter-panel-extend')]")
    private WebElement button;



    public void search(String priceTo,String electronics,String... proizvoditel){
        hrefMarket.click();
        hrefElectronics.get(0).click();
        hrefElectronics2Step.get(0).click();
        choiceElelectronics(hrefListElectronics,electronics);
        buttonAllFilters.click();
        inputPriceTo.sendKeys(priceTo);
        choiceProizvoditel(checkListProizvoditel,proizvoditel);
        button.click();
    }
    public void choiceElelectronics(List<WebElement> element,String text){
        for (WebElement el:element) {
            if(el.getText().equals(text)){
                el.click();
                return;
            }
        }
    }
    public void choiceProizvoditel(List<WebElement> element,String... massivProizvoditel){
        for(WebElement el:element){
            for(String proizvoditel:massivProizvoditel) {
                if (el.getText().equals(proizvoditel)) {
                    el.click();
                }
            }
        }
    }
}
