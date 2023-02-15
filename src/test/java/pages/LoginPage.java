package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By loginSubmitBtnLocator = By.cssSelector("button[type='submit']");

    By registrationInput = By.cssSelector("#hel");

    By registrationButton = By.cssSelector("input[value='Register']");

    public void provideEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickSubmitBtn () {
       driver.findElement(loginSubmitBtnLocator).click();
    }

    public void login(){
        provideEmail("vikazhuk0904@gmail.com");
        providePassword("te$t$tudent1");
        clickSubmitBtn();
    }

    public void clickRegistrationBtn () {
        driver.findElement(registrationInput).click();
    }

    public WebElement getRegistrationButton () {
        return wait.until(ExpectedConditions.elementToBeClickable(registrationButton));
    }
}
