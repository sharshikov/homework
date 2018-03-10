package pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReportPage extends BasePage {
    WebDriverWait wait;
    public ReportPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        wait = new WebDriverWait(BaseSteps.getDriver(), 10);
    }
    @FindBy(xpath = ".//*[contains(@class,'i-bem b-zone b-spy-visible n-snippet-cell2_type')]")
    private List<WebElement> elements;

    @FindBy(xpath = ".//*[contains(@class,'i-bem b-zone b-spy-visible')]//a[contains(@class,'link n-link_theme_blue')]")
    private List<WebElement> nameElements;

    @FindBy(xpath = ".//*[contains(@class,'i-bem b-zone b-spy-visible')]")
    private List<WebElement> elementsAfterShow12;

    @FindBy(xpath = ".//*[@class='link n-link_theme_blue']")
    private List<WebElement> elementsAfterSearch;

    @FindBy(xpath = ".//*[contains(@class,'rrow_down button_size_s select__button i-bem')]")
    private WebElement button1;

    @FindBy(xpath = ".//span[text()='Показывать по 12']")
    private WebElement button2;

    @FindBy(xpath = ".//input[@id='header-search']")
    private WebElement input;

    @FindBy(xpath = ".//button[contains(@class,'button2_size_ml button2')]")
    private WebElement buttonSearch;

    @FindBy(xpath = ".//h1[@class='title title_size_28 title_bold_yes']")
    private WebElement title;

    private String name;


    public void searchButton12(){
        if(elements.size()!=12){
        try {
            button1.click();
        }catch (NoSuchElementException e){
            return;
        }
        button2.click();
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Элементов не 12", elementsAfterShow12.size(), 12);
    }
    public void check(){
        input.sendKeys(nameElements.get(0).getText());
        name = nameElements.get(0).getText();

        buttonSearch.click();
        try{
            Assert.assertEquals("Элемент не найден",name,elementsAfterSearch.get(0).getText());

        }catch (IndexOutOfBoundsException e){
            Assert.assertEquals("Элекмент не найден",name,title.getText());
        }
    }

}
