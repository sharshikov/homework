package steps;

import pages.CartPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class CartSteps {
    CartPage cartPage = new CartPage();
    @Step("выполнена проверка есть ли элемент в корзине")
    public void checkElement(){cartPage.checkElement();}
    @Step("выполнено нажатие на кнопку удалить все")
    public void removeAll(){cartPage.removeAll();}
    @Step("заголовок страницы {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = cartPage.checkText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }
}
