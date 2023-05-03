import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    public String url = null;


//    @BeforeSuite
//    static void setupClass() {
//
//        WebDriverManager.chromedriver().setup();
//    }


    @BeforeMethod

    public void setUpBrowser() {
        String url = "https://bbb.testpro.io/";
        driver = pickBrowser(System.getProperty("browser"));
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait=new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.get(url);
    }

    public WebDriver pickBrowser(String browser){
        switch (browser){
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver=new EdgeDriver();
            default:
                WebDriverManager.chromedriver().setup();
                return driver=new ChromeDriver();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



    public void clickLoginSubmit() {
//        WebElement submitLogin= driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submitLogin= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitLogin.click();
    }

    public void enterPassword(String password) {
//        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String email) {
//        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginSubmit();
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
