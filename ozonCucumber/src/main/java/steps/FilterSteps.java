package steps;

import org.openqa.selenium.WebElement;
import pages.FilterPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class FilterSteps {
    FilterPage filterPage = new FilterPage();
    @Step("выбран производитель {0}")
    public void selectManufacturer(List<String> nameManufacturer) {
        filterPage.selectManufacturer(nameManufacturer);
    }
    @Step("установлена цена {0}")
    public void setPrice(String valuePrice){filterPage.setPrice(valuePrice);}
    @Step("выполнено нажатие на кнопку применить")
    public void clickButtonApply(){filterPage.clickButtonApply();}
}
