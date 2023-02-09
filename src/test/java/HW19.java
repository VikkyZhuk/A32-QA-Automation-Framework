import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HW19 extends BaseTest {

    @Test
    public void deletePlaylistTest() {
        enterEmail("vikazhuk0904@gmail.com");
        enterPassword("te$t$tudent1");
        loginSubmit();

        List <WebElement> playlists = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".playlist.playlist>a")));
        int playlistNumber=playlists.size();
        playlists.get(playlistNumber-1).click();
        String name = playlists.get(playlistNumber-1).getText();
        System.out.println(name);

        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-delete-playlist")));
        deletePlaylistBtn.click();

        String notificationText = "Deleted playlist \"" +name+ ".\"";
        
        System.out.println(notificationText);

        String notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show"))).getText();
        System.out.println(notification);

        Assert.assertEquals(notificationText,notification);







    }

}
