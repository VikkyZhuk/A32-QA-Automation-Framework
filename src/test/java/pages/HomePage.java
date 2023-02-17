package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "img.avatar")
    private WebElement avatarIcon;
    @FindBy(css = ".menu .songs")
    private WebElement allSongsLink;
    @FindBy(css = "[data-testid='play-btn']")
    private WebElement playBtn;
    @FindBy(css = "[data-testid='pause-btn']")
    private WebElement pauseBtn;
    @FindBy(css = ".btn-delete-playlist")
    private WebElement deletePlaylistBtn;
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement playlistElement;
    @FindBy(css = "input[name='name']")
    private WebElement playlistInputField;
    @FindBy(css = ".playlist:nth-child(3)>a")
    private WebElement playlistElementText;
    @FindBy(css = ".success.show")
    private WebElement notificationDelete;
    @FindBy(css=".playlist.playlist>a")
            private List<WebElement> playlists;
    public int playlistSize (){
        return playlists.size();
    }
    public WebElement playlistLast (){
        return playlists.get(playlistSize()-1);
    }

    public HomePage doubleClickPlaylist() {
        doubleClick(playlistElement);
        return this;
    }

    public WebElement getUserAvatar() {
        wait.until(ExpectedConditions.visibilityOf(avatarIcon));
        return avatarIcon;
    }

    public HomePage clickAllSongsLink() {
        allSongsLink.click();
        return this;
    }

    public HomePage clickPlayBtn() {
        actions.moveToElement(playBtn).perform();
        playBtn.click();
        return this;
    }

    public boolean pauseBtnPresence() {
        return pauseBtn.isDisplayed();
    }

    public HomePage clickDeletePlaylistBtn() {
        deletePlaylistBtn.click();
        return this;
    }

    public HomePage enterPlaylistName(String name) {
        wait.until(ExpectedConditions.visibilityOf(playlistInputField));
        playlistInputField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);
        return this;

    }

    public String getPlaylistName() {
        wait.until(ExpectedConditions.visibilityOf(playlistElementText));
        String name = playlistElementText.getText();
        return name;
    }

    public String notificationDeletePlaylist() {
        wait.until(ExpectedConditions.visibilityOf(notificationDelete));
        return notificationDelete.getText();

    }
}









