import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Test {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.sberbank.ru/ru/person");
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @org.junit.Test
    public void scrollFooter() {
        driver.findElement(By.xpath(".//*[@class='region-list__name']")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver,5,1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@class='region-list__modal-caption']"))));
        driver.findElement(By.xpath(".//*[@placeholder='Введите название региона']")).sendKeys("Нижегородская область");
        driver.findElement(By.xpath(".//*[@class='region-search-box__option']")).click();
        assertEquals("ошибка","Нижегородская область",driver.findElement(By.xpath(".//*[@class='region-list__name']")).getText());
        WebElement webElem = driver.findElement(By.xpath(".//*[@class = 'sbrf-div-list-inner --area bp-area footer-white']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);",webElem);
        check("fb']",webElem,"facebook");
        check("tw']",webElem,"twitter");
        check("yt']",webElem,"youtube");
        check("ins']",webElem,"instagram");
        check("vk']",webElem,"vk");
        check("ok']",webElem,"odnoklassniki");
    }
    private void check(String iconPathEnd, WebElement webElem,String message){
        String iconPath = ".//*[@class='social__icon social__icon_type_";
        try {
            webElem.findElement(By.xpath(iconPath + iconPathEnd));
            }
            catch (NoSuchElementException e){
                System.out.println("Нет значка "+message);
            }
    }

}
