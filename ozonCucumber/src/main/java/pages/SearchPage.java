package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class SearchPage extends BasePage{
    public SearchPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    @FindBy(xpath = ".//div[contains(@class,'_close jsCloseBanner')]")
    private WebElement banner;

    @FindBy(xpath = ".//span[@class='eHeaderCatalogButton_Text']")
    private WebElement allCategoryButton;

    @FindBy(xpath = ".//span[@class='eOzonCatalog_1LevelLinkText']")
    private List<WebElement> menu;

    @FindAll({@FindBy(xpath = ".//a[@class='eLeftMainMenu_Title']"),
            @FindBy(xpath = ".//a[@class='eLeftMainMenu_Link ']")})
    private List<WebElement> category;



    public void bannerClose(){
        try{
            banner.click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }
    public void selectMenu(String nameMenu){
        allCategoryButton.click();
        searchElement(menu,nameMenu).click();
    }
    public void selectCategory(String nameCategory){
        searchElement(category,nameCategory).click();
    }

}
