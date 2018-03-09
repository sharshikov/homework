package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class ReportPage extends BasePage {
    public ReportPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    @FindBy(xpath = ".//*[contains(@class,'link n-link_theme_blue')]")
    private List<WebElement> elements;

    @FindBy(xpath = ".//*[contains(@class,'rrow_down button_size_s select__button i-bem')]")
    private WebElement button1;

    @FindBy(xpath = ".//span[text()='Показывать по 12']")
    private WebElement button2;

    @FindBy(xpath = ".//input[@id='header-search']")
    private WebElement input;

    public void searchButton(){
        try {
            button1.click();
        }catch (NoSuchElementException e){
            return;
        }
        button2.click();
    }
    public void inputName(){
        input.sendKeys(elements.get(0).getText());
        Assert.assertEquals("Ошибка",elements.get(0).getText(),input.getAttribute("value"));
    }

}
