import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;


public class BaseTest {
    WebDriver driver;
    public String url = "https://bbb.testpro.io/";
    WebDriverWait wait;

    ThreadLocal<WebDriver> threadDriver;


//    @BeforeSuite
//    static void setupClass() {
//        WebDriverManager.chromedriver().setup();
//    }

    @BeforeMethod

    public void setUpBrowser() throws MalformedURLException {
//        String url = "https://bbb.testpro.io/";
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//        driver = new ChromeDriver(options);
        driver = pickBrowser (System.getProperty("browser"));

        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(4));
        driver.manage().window().maximize();
        driver.get(url);

    }

    public WebDriver getThreadDriver(){
        return threadDriver.get();
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String userName = "vikazhuk0904";
        String authkey = "eEIyGIwu48HbXzTyWIPyBUsyT076Wk3YikxNs8VsoGkvGLKKUU";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platform", "Windows 11");
        desiredCapabilities.setCapability("browserName", "Chrome");
        desiredCapabilities.setCapability("version", "110.0");
        desiredCapabilities.setCapability("resolution", "1920x1080");
        desiredCapabilities.setCapability("build", "TestNG With Java");
        desiredCapabilities.setCapability("name", this.getClass().getName());
        desiredCapabilities.setCapability("plugin", "git-testng");

        return new RemoteWebDriver(new URL("https://" + userName + ":" + authkey + hub), desiredCapabilities);
    }


    public WebDriver pickBrowser(String browser) throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://192.168.5.21:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return driver = new EdgeDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "grid-edge":
                caps.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver();

        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void loginSubmit() {
        WebElement submitLogin = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitLogin.click();
    }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        loginSubmit();
    }
}
