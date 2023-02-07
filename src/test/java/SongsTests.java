import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class SongsTests extends BaseTest {

    @Test
    public void playSongTest() {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        clickPlayBtn();
        Assert.assertTrue(pauseBtnExists());

        // Comparing numbers of elements example
        List<WebElement> songs = driver.findElements(By.cssSelector(".song-item"));
        int songsNumberBefore = songs.size();
        System.out.println(songsNumberBefore);
        // Just an example: here we would add or delete an element but we didn't
        int songsNumberAfter = songs.size();
        System.out.println(songsNumberAfter);

        // Soft assert example
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://bbb.testpro.io/#!/queue");
        softAssert.assertTrue(songsNumberBefore == songsNumberAfter, "=== Songs number before should be equal songs number after ===");
        softAssert.assertAll();
    }

    @Test
    public void checkVisibilityTest() {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        WebElement title = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("title")));
        String text = title.getText();
        System.out.println(text);
        System.out.println("Is element visible? === " + wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("title"))));
        WebElement title2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("title")));  // should fail
    }

    @Test
    public void deletePlaylistTest() {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        List<WebElement> playlists = driver.findElements(By.cssSelector("section#playlists > ul > li"));
        int playlistsNumber = playlists.size();
        playlists.get(playlistsNumber - 1).click();

    }

        public void clickPlayBtn() {
        Actions action = new Actions(driver);
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        action.moveToElement(playBtn).perform();
        playBtn.click();
    }

    public boolean pauseBtnExists(){
        return driver.findElement(By.cssSelector("[data-testid='pause-btn']")).isDisplayed();
    }

}
