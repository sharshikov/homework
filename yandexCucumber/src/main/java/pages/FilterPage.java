package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class FilterPage extends BasePage {
    public FilterPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    @FindBy(xpath = ".//*[text()='Перейти ко всем фильтрам']")
    private WebElement buttonAllFilters;

    @FindBy(xpath = ".//*[contains(@name,'glf-priceto-var')]")
    private WebElement inputPriceTo;

    @FindBy(xpath = ".//*[contains(@class,'n-filter-block__body i-bem n-filter-block__body_js_inited')]//label[@class='checkbox__label']")
    private List<WebElement> manufacturer;

    @FindBy(xpath = ".//*[contains(@class,'button_action_show-filtered n-filter-panel-extend')]")
    private WebElement button;

    public void selectFilter() {
        buttonAllFilters.click();
    }

    public void setInputPriceTo(String price) {
        inputPriceTo.sendKeys(price);
    }

    public void selectManufacturer(List<String> nameManufacturer) {
        List<WebElement> manufactures = searchElements(manufacturer, nameManufacturer);
        for(WebElement item:manufactures){
            item.click();
        }
    }
    public void showList(){
        button.click();
    }
}
