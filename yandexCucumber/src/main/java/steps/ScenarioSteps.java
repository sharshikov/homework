package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by m.baykova on 13.09.2017.
 */
public class ScenarioSteps {

    SearchSteps searchSteps = new SearchSteps();
    FilterSteps filterSteps = new FilterSteps();
    ReportSteps reportSteps = new ReportSteps();

    @When("^выбран раздел \"(.+)\"$")
    public void selectSect(String nameElement){ searchSteps.selectSect(nameElement);
    }
    @When("^выбрана категория \"(.+)\"$")
    public void selectCategory(String nameElement){
        searchSteps.selectCategory(nameElement);
    }

    @When("^выбран раздел электроники: \"(.+)\"$")
    public void selectEletronic(String nameElement){ searchSteps.selectEletronic(nameElement); }

    @Then("^заголовок страницы - \"(.+)\"$")
    public void checkTitleDMSPage(String title){
        searchSteps.checkPageTitle(title);
    }

    @When("^выполнено нажатие на кнопку фильтры$")
    public void selectFilter(){ filterSteps.selectFilter(); }

    @When("^введено значение цены до: \"(.+)\"$")
    public void setInputPriceTo(String price){ filterSteps.setInputPriceTo(price); }

    @When("^выбраны производители \"(.+)\"$")
    public void selectManufacturer(List<String> price){
        filterSteps.selectManufacturer(price);
    }

    @When("^выполнено нажатие на кнопку показать подходящие$")
    public void showList(){ filterSteps.showList(); }

    @When("^выполнено нажатие на кнопку показать по 12$")
    public void searchButton(){reportSteps.searchButton();}

    @Then("^проверяем значение$")
    public void inputName (){ reportSteps.inputName();
    }
}
