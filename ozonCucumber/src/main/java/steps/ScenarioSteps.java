package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class ScenarioSteps {
    SearchSteps searchSteps = new SearchSteps();
    FilterSteps filterSteps = new FilterSteps();
    ReportSteps reportSteps = new ReportSteps();
    CartSteps cartSteps = new CartSteps();

    @When("^закрыли баннер$")
    public void bannerClose() {
        searchSteps.bannerClose();
    }

    @When("^выбран пункт меню \"(.+)\"$")
    public void selectMenu(String nameMenu) {
        searchSteps.selectMenu(nameMenu);
    }

    @When("^выбрана категория \"(.+)\"$")
    public void selectCategory(String nameCategory) {
        searchSteps.selectCategory(nameCategory);
    }

    @When("^выбран производитель \"(.+)\"$")
    public void selectManufacturer(List<String> nameManufacturer) {
        filterSteps.selectManufacturer(nameManufacturer);
    }
    @When("^установлена цена \"(.+)\"$")
    public void setPrice(String valuePrice){filterSteps.setPrice(valuePrice);}

    @When("^выполнено нажитие на кнопку применить$")
    public void clickButtonApply(){filterSteps.clickButtonApply();}

    @When("^добавлен первый элемент в корзину$")
    public void addFirstElementToCart(){reportSteps.addFirstElementToCart();}

    @When("^выполнено нажатие на кнопку корзина$")
    public void toCart(){reportSteps.toCart();}

    @When("^выполнена проверка$")
    public void checkElement(){cartSteps.checkElement();}

    @When("^выполнено нажатие на кнопку удалить все$")
    public void removeAll(){cartSteps.removeAll();}

    @Then("^заголовок страницы - \"(.+)\"$")
    public void checkPageTitle(String title){
        cartSteps.checkPageTitle(title);
    }
}
