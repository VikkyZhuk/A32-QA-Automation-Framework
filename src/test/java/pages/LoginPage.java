package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public String url = "https://bbb.testpro.io/";


    @FindBy(css="[type='email']")
            private WebElement emailField;
    @FindBy(css="[type='password']")
            private WebElement passwordField;
    @FindBy(css="button[type='submit']")
            private WebElement loginSubmitBtnLocator;
    @FindBy(css="#hel")
            private WebElement registrationInput;
    @FindBy(css = "input[value='Register']")
            private WebElement registrationButton;


    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickSubmitBtn () {
        loginSubmitBtnLocator.click();
    }

    public void login(){
        provideEmail("viktoryia.zhuk@testpro.io");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }

    public void clickRegistrationBtn () {
       registrationInput.click();
    }

    public WebElement getRegistrationButton () {
        return wait.until(ExpectedConditions.elementToBeClickable(registrationButton));
    }
    public String returnUrl() {
        driver.get(url);
        return (url);
    }



}
