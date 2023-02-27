package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseStepDef {
    WebDriver driver;
    WebDriverWait wait;
    public String url = "https://bbb.testpro.io/";

    @Before
    public void iOpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
