package pages;

import javafx.scene.control.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.security.Key;
import java.util.List;

public class FilterPage extends BasePage {
    WebDriverWait wait;
    public FilterPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        wait = new WebDriverWait(BaseSteps.getDriver(), 10);
    }

    @FindBy(xpath = ".//span[@class='eBottomRoll_Link']")
    private WebElement buttonAllManufacturer;

    @FindBy(xpath = ".//input[@class='eFilterList_SearchInput']")
    private WebElement inputManufcturer;

    @FindBy(xpath = ".//a[@class='eFilterList_OptionLink']")
    private List<WebElement> manufcturer;

    @FindBy(xpath = ".//input[@class='eFromToInput_InputField mFrom']")
    private WebElement price;

    @FindBy(xpath = ".//div[@class='bFiltersHor']//div[@class='bFilterApply']")
    private WebElement buttonApply;

    @FindBy(xpath = ".//*[contains(text()='Применить')]")
    private WebElement buttonApplyCss;

    public void selectManufacturer(List<String> nameManufacturer){
        for(String item:nameManufacturer) {
           searchElement(manufcturer,item).click();
        }
    }
    public void setPrice(String valuePrice){
        price.clear();
        price.sendKeys(valuePrice);
        price.sendKeys(Keys.TAB);
    }
    public void clickButtonApply(){
        //wait.until(ExpectedConditions.visibilityOf(buttonApply));
        buttonApply.click();
    }
}
