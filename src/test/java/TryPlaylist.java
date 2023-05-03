import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class TryPlaylist extends BaseTest {

    @Test
    public void playSongFromListTest() {
        login("viktoryia.zhuk@testpro.io", "te$t$tudent1");
        WebElement allSongs = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".menu .songs")));
        allSongs.click();
        WebElement firstSong = driver.findElement(By.cssSelector(".song-item"));

        Actions action = new Actions(driver);
        action.contextClick(firstSong).perform();

        clickPlayBtn();
//        WebElement playBtn = driver.findElement(By.cssSelector(".playback"));
//        playBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
    }

    public void clickPlayBtn() {
        Actions actions = new Actions(driver);
        WebElement playBtn = driver.findElement(By.cssSelector(".playback"));
        actions.moveToElement(playBtn).perform();
        playBtn.click();
    }

    @Test
    public void countSongsInPlaylistTest(){
        login("viktoryia.zhuk@testpro.io", "te$t$tudent1");
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(4)")));
        playlist.click();

        List<WebElement> songs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#playlistWrapper .song-item")));
        int number = songs.size();
        Assert.assertEquals(number, 4);
    }

    @Test
    public void renamePlaylist(){
        login("viktoryia.zhuk@testpro.io", "te$t$tudent1");
        doubleClickChoosePlaylist();
//        WebElement playlistElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
//        Actions action = new Actions(driver);
//        action.doubleClick(playlistElement).perform();
        String playlistName = generateRandomName();
        enterPlaylistName (playlistName);
        String newName = getPlaylistName();
        Assert.assertEquals(newName, playlistName);
    }

    public void doubleClickChoosePlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        Actions action = new Actions(driver);
        action.doubleClick(playlistElement).perform();
    }

    public void enterPlaylistName(String name){
        WebElement playlistInputField= driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getPlaylistName(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)>a")));
        String name = playlistElement.getText();
        return name;
    }

}
