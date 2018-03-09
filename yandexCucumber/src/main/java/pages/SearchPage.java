package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage extends BasePage {
    WebDriverWait wait;
    Actions actions;
    public SearchPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        wait = new WebDriverWait(BaseSteps.getDriver(), 10);
        actions = new Actions(BaseSteps.getDriver());
    }

    @FindAll({@FindBy(xpath = ".//a[contains(@class,'home-link home-link_blue')]")})
    private List<WebElement>section;

    @FindBy(xpath = ".//a[@class='link topmenu__link']")
    private List<WebElement>category;

    @FindBy(xpath = ".//a[contains(@class,'metrika i-bem metrika_js_inited')]")
    private List<WebElement>electronic;

    @FindBy(xpath = ".//*[contains(@class,'-topmenu-new-vertical__popup-show button_size_m button_theme')]")
    private WebElement category2;

    @FindBy(xpath = ".//h1[contains(@class,'title title_size_32 i-bem')]")
    public WebElement title;


    @FindBy(xpath = ".//*[contains(@class,'n-navigation-vertical-category__link link i-bem')]//*[text()='Электроника']")
    private WebElement category3;

    public void selectSection(String nameElement){
        searchElement(section,nameElement).click();
    }
    public void selectCategory(String nameElement){
//        try{
//        TimeUnit.HOURS.sleep(1);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }

        try {
            category2.click();
            wait.until(ExpectedConditions.visibilityOf(category3));
            category3.click();
        }catch (NoSuchElementException e){
            searchElement(category,nameElement).click();
            //actions.moveToElement(category2).click().perform();
        }
    }
    public void selectElectronic(String nameElement){

        searchElement(electronic,nameElement).click();
    }

}
