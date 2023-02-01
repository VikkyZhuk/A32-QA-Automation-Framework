import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW16 extends BaseTest {
    @Test
    public static void registrationNavigationTest (){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationInput = driver.findElement(By.cssSelector("#hel"));
        registrationInput.click();
        WebElement registrationButton = driver.findElement(By.cssSelector("input[value='Register']"));
        Assert.assertTrue(registrationButton.isDisplayed());
        driver.quit();

    }
}
