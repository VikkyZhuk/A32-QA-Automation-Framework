package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDef {
    WebDriver driver;
    WebDriverWait wait;
    public String url = "https://bbb.testpro.io/";

    @Before
    public void iOpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Given("I open login page")
    public void iOpenLoginPage(){
        driver.get(url);
    }

    @When("I provide email {string}")
    public void iProvideEmail(String email) {
        LoginPage loginPage = new LoginPage (driver);
        loginPage.provideEmail(email);
    }

    @And("I provide password {string}")
    public void iProvidePassword(String password) {
        LoginPage loginPage = new LoginPage (driver);
        loginPage.providePassword(password);
    }

    @And("I click on submit button")
    public void iClickOnSubmitButton() {
        LoginPage loginPage = new LoginPage (driver);
        loginPage.clickSubmitBtn();
    }

    @Then("I am on Home Page")
    public void iAmOnHomePage() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

//    @Then("I stayed on Login Page")
//    public void iStayedOnLoginPage() {
//        LoginPage loginPage = new LoginPage(driver);
//            Assert.assertEquals(loginPage.returnUrl(), url);
//    }
    @Then("I stayed on Login Page")
    public void iStayedOnLoginPage() {
        String urlHomePage = "https://bbb.testpro.io/#!/home";
        Assert.assertNotEquals(driver.getCurrentUrl(), urlHomePage);
    }


}
