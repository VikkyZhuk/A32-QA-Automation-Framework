import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW16 extends BaseTest {
    @Test
    public void registrationNavigationTest(){
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);

        WebElement registrationInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#hel")));
        registrationInput.click();
        WebElement registrationButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Register']")));
        Assert.assertTrue(registrationButton.isDisplayed());
        driver.quit();

    }
}
