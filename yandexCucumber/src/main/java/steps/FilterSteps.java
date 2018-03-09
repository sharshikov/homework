package steps;

import ru.yandex.qatools.allure.annotations.Step;
import pages.FilterPage;

import java.util.List;

public class FilterSteps {
    FilterPage filter = new FilterPage();
    @Step("выполнено нажатие на \"перейти ко всем фильтрам\"")
    public void selectFilter(){
       filter.selectFilter();
    }
    @Step("введено значение цены до: {0}")
    public void setInputPriceTo(String price){
        filter.setInputPriceTo(price);
    }
    @Step("Выбран производитель {0}")
    public void selectManufacturer(List<String> price){
        filter.selectManufacturer(price);
    }
    @Step("выполнено нажатие на \"показать подходящие\"")
    public void showList(){
        filter.showList();
    }

}
