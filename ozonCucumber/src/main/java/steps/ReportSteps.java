package steps;

import pages.ReportPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class ReportSteps {
    ReportPage reportPage = new ReportPage();
    @Step("добавили первый элемент в корзину {0}")
    public void addFirstElementToCart(){reportPage.addFirstElementToCart();}

    @Step("выполнено нажатие на кнопку корзина{0}")
    public void toCart(){reportPage.toCart();}
}
