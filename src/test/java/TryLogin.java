import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class TryLogin extends BaseTest{
    @Test
    public void LoginSuccedTest(){
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        String url="https://bbb.testpro.io/";
//        driver.get(url);

        enterEmail("viktoryia.zhuk@testpro.io");

//        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
//        emailInput.click();
//        emailInput.sendKeys("viktoryia.zhuk@testpro.io");
        enterPassword("te$t$tudent1");

//        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
//        passwordInput.click();
//        passwordInput.sendKeys("te$t$tudent1");
        clickLoginSubmit();

//        WebElement submitLogin= driver.findElement(By.cssSelector("button[type='submit']"));
//        submitLogin.click();

        WebElement avatar = driver.findElement(By.className("avatar"));
        Assert.assertTrue(avatar.isDisplayed());

//        driver.quit();
    }

    @Test
    public void changeProfileNameTest(){
        enterEmail("viktoryia.zhuk@testpro.io");
        enterPassword("te$t$tudent1");
        clickLoginSubmit();
        WebElement avatar = driver.findElement(By.className("avatar"));
        Assert.assertTrue(avatar.isDisplayed());

        WebElement userName = driver.findElement(By.cssSelector(".view-profile .name"));
        String user1 = userName.getText();
        System.out.println(user1);

        String user2 = generateRandomName();
        System.out.println(user2);

        avatar.click();

        WebElement nameInput = driver.findElement(By.cssSelector("#inputProfileName"));
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(user2);

        WebElement passwordInput= driver.findElement(By.cssSelector("#inputProfileCurrentPassword"));
        passwordInput.click();
        passwordInput.sendKeys("te$t$tudent1");

        WebElement saveButton = driver.findElement(By.cssSelector(".btn-submit"));
        saveButton.click();

        Assert.assertEquals(userName, user2);


    }
    

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-","");
    }


    private void clickLoginSubmit() {
        WebElement submitLogin= driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }

    private void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.sendKeys(email);
    }
}
