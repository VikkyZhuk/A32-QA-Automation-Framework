import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW18 extends BaseTest{

    @Test

    public void playSong (){
        enterEmail("vikazhuk0904@gmail.com");
        enterPassword("te$t$tudent1");
        loginSubmit();
        clickPlayBtn();
        WebElement pauseBtn = driver.findElement(By.cssSelector("[data-testid='pause-btn']"));
        Assert.assertTrue(pauseBtn.isDisplayed());


    }

    public void clickPlayBtn () {
        Actions action = new Actions (driver);
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        action.moveToElement(playBtn).perform();
        playBtn.click();
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void loginSubmit() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }
}
