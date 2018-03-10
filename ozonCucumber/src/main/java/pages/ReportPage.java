package pages;

import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(xpath = ".//*[@class='bItemName']")
    private WebElement nameElement;

    @FindBy(xpath = ".//*[@class='eOzonPrice_main']")
    private WebElement priceElement;

    @FindBy(xpath = ".//*[@class='eOzonPrice_submain']")
    private WebElement subPriceElement;

    public static String price;
    public static String name;

    public void addFirstElementToCart(){
        element.get(0).click();
        buttonAddToCart.click();
        name = nameElement.getText();
        try {
            price = priceElement.getText()+","+subPriceElement.getText();
        }catch (NoSuchElementException e){
            price = priceElement.getText()+",00";
        }
    }
    public void toCart(){
        toCart.click();
    }
}
