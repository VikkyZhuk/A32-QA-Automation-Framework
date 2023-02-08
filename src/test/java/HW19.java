import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HW19 extends BaseTest {

    @Test
    public void deletePlaylistTest() {
        enterEmail("vikazhuk0904@gmail.com");
        enterPassword("te$t$tudent1");
        loginSubmit();

        List <WebElement> playlists = driver.findElements(By.cssSelector(".playlist.playlist>a"));
        int playlistNumber=playlists.size();
        playlists.get(playlistNumber-1).click();
        String name = playlists.get(playlistNumber-1).getText();
        System.out.println(name);

        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlaylistBtn.click();

        String notificationText = "Deleted playlist \"" +name+ ".\"";
        
        System.out.println(notificationText);

        String notification = driver.findElement(By.cssSelector(".success.show")).getText();
        System.out.println(notification);

        Assert.assertEquals(notificationText,notification);







    }

}
