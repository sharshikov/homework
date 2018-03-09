package steps;

import pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Step;

public class SearchSteps {
    SearchPage search = new SearchPage();

    @Step("закрыли баннер {0}")
    public void bannerClose() {
        search.bannerClose();
    }

    @Step("выбран пункт меню {0}")
    public void selectMenu(String nameMenu) {
        search.selectMenu(nameMenu);
    }

    @Step("выбрана категория {0}")
    public void selectCategory(String nameCategory) {
        search.selectCategory(nameCategory);
    }

}
