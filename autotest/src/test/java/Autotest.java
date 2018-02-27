import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by aasx .
 */
public class Autotest {

    private WebDriver driver;

//    1. Перейти по ссылке http://www.rgs.ru
//            2. Выбрать пункт меню - Страхование
//3. Выбрать категорию - ДМС
//4. Проверить наличие заголовка - Добровольное медицинское страхование
//5. Нажать на кнопку - Отправить заявку
//6. Проверить, что открылась страница , на которой присутствует текст - Заявка на добровольное медицинское страхование
//7.Заполнить поля
//    Имя
//            Фамилия
//    Отчество
//            Регион
//    Телефон
//    Эл. почта - qwertyqwerty
//            Комментарии
//    Я согласен на обработку
//
//8. Проверить, что все поля заполнены введенными значениями
//9. Нажать Отправить
//10. Проверить, что у Поля - Эл. почта присутствует сообщение об ошибке - Введите корректный email



    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rgs.ru/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        WebElement navbar = driver.findElement(By.xpath(".//div[contains(@id, 'main-navbar')]"));
        navbar.findElement(By.xpath(".//a[contains(text(), 'Страхование')]")).click();
        navbar.findElement(By.xpath(".//a[contains(text(), 'ДМС')]")).click();
        assertEquals("Заголовок ДМС не соответствует ожидаемому", "ДМС \uD83D\uDE91 Добровольное медицинское страхование, рассчитать стоимость в Росгосстрахе", driver.getTitle());
        driver.findElement(By.xpath(".//a[contains(text(),'Отправить заявку')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver,5,1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@class='modal-title']/b"))));
        String exptectedTitle = driver.findElement(By.xpath(".//*[@class='modal-title']/b")).getText();
        assertEquals("У модального окна не правильный заголовок h4","Заявка на добровольное медицинское страхование", exptectedTitle);

        fillField(".//*[@name='LastName']","Тестов");
        fillField(".//*[@name='FirstName']","Тест");
        fillField(".//*[@name='MiddleName']","Тестович");
        WebElement element = driver.findElement(By.name("Region"));
        Select select = new Select(element);
        select.selectByVisibleText("Тверская область");
        fillField(".//*[@name='Email']","qwertyqwerty");
        fillField(".//*[@class='form-control']","9999999999","+7 (999) 999-99-99");
        fillField(".//*[@name='Comment']","Ok");
        driver.findElement(By.xpath(".//input[contains(@data-bind, 'IsProcessingPersonalData')]")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@class='validation-error-text']"))));
        Assert.assertEquals("ошибка","Введите адрес электронной почты",driver.findElement(By.xpath(".//*[@class='validation-error-text']")).getText());
        System.out.println("Ура мы открыли rgs");
    }
    private void fillField(String xpath,String valueInput, String valueCheck ){
        WebElement el = driver.findElement(By.xpath(xpath));
        el.clear();
        Actions act = new Actions(driver);
        act.moveToElement(el).click().sendKeys(valueInput).perform();
        Assert.assertEquals("ошибка",valueCheck,el.getAttribute("value"));
    }
    private void fillField(String xpath,String value){
        fillField(xpath,value,value);
    }
}