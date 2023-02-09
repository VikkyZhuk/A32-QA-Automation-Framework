import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW17 extends BaseTest {
    @Test
    public void addSongsToPlaylistTest() {
        enterEmail("vikazhuk0904@gmail.com");
        enterPassword("te$t$tudent1");
        loginSubmit();

        WebElement allSongsLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".menu .songs")));  //.menu .songs   //.songs.active
        allSongsLink.click();

        WebElement song = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".song-item .title")));
        String songName = song.getText();
        song.click();

        WebElement addToButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-add-to")));
        addToButton.click();

        WebElement playlist1ScrollDown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#songsWrapper .playlist")));
        playlist1ScrollDown.click();

//        WebElement playlist1 = driver.findElement(By.cssSelector("#playlists .active"));
//        playlist1.click();


    }

}
