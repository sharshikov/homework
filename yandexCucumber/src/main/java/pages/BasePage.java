package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
    public WebElement searchElement(List<WebElement> nameListElements, String nameElement ){
        for (WebElement item : nameListElements ){
            if (item.getText().equals(nameElement)){
                return item;
            }
        }
        Assert.fail("Не найден элемент коллеции - " + nameElement);
        return null;
    }

    public List<WebElement> searchElements(List<WebElement> nameListElements, List<String> nameElements ){
        List<WebElement> elements = new ArrayList<>();
        for(WebElement item : nameListElements){
            for(String name:nameElements){
                if (item.getText().equals(name)){
                    elements.add(item);
                }
            }
        }
        if(elements.isEmpty()) {
            Assert.fail("Не найден элемент коллеции - " + nameElements);
            return null;
        }
        return elements;
    }
}
