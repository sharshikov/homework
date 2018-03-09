package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class CartPage extends BasePage {
    Wait wait;
    Actions actions;
    ReportPage reportPage = new ReportPage();
    public CartPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
        actions = new Actions(BaseSteps.getDriver());
        wait = new WebDriverWait(BaseSteps.getDriver(), 10);
    }
    @FindBy(xpath = ".//div[contains(@class,'bCartItem jsChild_DOM_items_')]")
    private WebElement elementInCart;
    @FindBy(xpath = ".//*[@class='bIconButton mRemove mGray jsRemoveAll']")
    private WebElement buttonRemoveAll;
    @FindBy(xpath = ".//span[@class='jsInnerContentpage_title']")
    private WebElement title;
    @FindBy(xpath = ".//a[@class='bFlatButton mHuge']")
    private WebElement check1;
    @FindBy(xpath = ".//div[@class='eShelfBlock_title']")
    private WebElement check2;
    @FindBy(xpath = ".//span[@class='eCartItem_nameValue']")
    private WebElement nameElementInCart;
    @FindBy(xpath = ".//div[@class='eCartItem_price']")
    private WebElement priceElementInCart;


    public void checkElement(){
        Assert.assertEquals("Ошибка",elementInCart.getAttribute("data-id"),reportPage.idElement);
    }
    public void removeAll() {
        wait.until(ExpectedConditions.visibilityOf(check2));
        buttonRemoveAll.click();
    }
    public String checkText(){
        wait.until(ExpectedConditions.visibilityOf(check1));
        return title.getText();
    }
}
