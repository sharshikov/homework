package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class ReportPage {
    public ReportPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    @FindBy(xpath = ".//div[@class='bOneTile inline jsUpdateLink mRuble ']")
    private List<WebElement> element;

    @FindBy(xpath = ".//div[@class='bSaleBlockButton jsButton']")
    private WebElement buttonAddToCart;

    @FindBy(xpath = ".//a[@href='/context/cart']")
    private WebElement toCart;

    public static String nameElement;
    public static String priceElement;
    public static String idElement;

    public void addFirstElementToCart(){
        idElement = element.get(0).getAttribute("data-itemid");
        nameElement=element.get(0).getAttribute("data-name");
        priceElement=element.get(0).getAttribute("data-price");
        element.get(0).click();
        buttonAddToCart.click();
    }
    public void toCart(){
        toCart.click();
    }
}
