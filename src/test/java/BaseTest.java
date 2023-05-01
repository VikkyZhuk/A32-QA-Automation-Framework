import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;


public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    public String url = null;


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpBrowser() {
        String url = "https://bbb.testpro.io/";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait=new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
