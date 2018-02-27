import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void test1() {
        driver.findElement(By.xpath("//*[text()='Москва']")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver,5,1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@class='region-list__modal-caption']"))));
        driver.findElement(By.xpath(".//a[contains(text(), 'Нижегородская область')]")).click();
//        WebElement element = driver.findElement(By.id("region-list__select-widget_3224fb10-6bde-450d-a126-cca402633669"));
//        Select select = new Select(element);
//        select.selectByVisibleText("Нижегородская область");
//        select.getFirstSelectedOption();
    }

}
