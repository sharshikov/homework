package steps;

import pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class SearchSteps {
    SearchPage search = new SearchPage();
    @Step("выбран раздел: {0}")
    public void selectSect(String nameElement){
        search.selectSection(nameElement);
    }
    @Step("выбрана категория: {0}")
    public void selectCategory(String nameElement){
        search.selectCategory(nameElement);
    }
    @Step("выбран раздел электроники: {0}")
    public void selectEletronic(String nameElement){
        search.selectElectronic(nameElement);
    }
    @Step("заголовок страницы {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = search.title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

}
