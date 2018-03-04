import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Properties;

public class SearchTest {
    WebDriver driver;
    @Before
    public void setUp(){
        Properties property = TestProperties.getProperty();
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(property.getProperty("app.url"));
    }
    @After
    public void Done(){
        driver.quit();
    }
    @Test
    public void testHeadPhones(){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search("20000","Наушники и Bluetooth-гарнитуры","Samsung","Beats");
        new ReportPage(driver).report();
    }
    @Test
    public void testTV(){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search("20000","Телевизоры","Samsung","LG");
        new ReportPage(driver).report();
    }

}
