import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW17 extends BaseTest {
    @Test
    public void addSongsToPlaylistTest()  {
        enterEmail("vikazhuk0904@gmail.com");
        enterPassword("te$t$tudent1");
        loginSubmit();

        WebElement allSongsLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".menu .songs")));
        allSongsLink.click();

        WebElement song = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".song-item .title")));
        String songName = song.getText();
        System.out.println(songName);
        song.click();

        WebElement addToButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-add-to")));
        addToButton.click();

        WebElement playlist1ScrollDown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".add-to .existing-playlists .playlist")));
        playlist1ScrollDown.click();

        Assert.assertTrue(isNotificationPopUpPresent());


    }
    public String getNotificationText(){
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.getText();
    }

    public boolean isNotificationPopUpPresent () {
        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return notificationText.isDisplayed();
    }


}
