import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW18 extends BaseTest{

    @Test

    public void playSong (){
        enterEmail("vikazhuk0904@gmail.com");
        enterPassword("te$t$tudent1");
        loginSubmit();
        clickPlayBtn();
        WebElement pauseBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='pause-btn']")));
        Assert.assertTrue(pauseBtn.isDisplayed());


    }

    public void clickPlayBtn () {
        Actions action = new Actions (driver);
        WebElement playBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        action.moveToElement(playBtn).perform();
        playBtn.click();
    }

}
