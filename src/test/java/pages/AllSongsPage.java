package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css="div.success.show")
            private WebElement notificationText;
    @FindBy(css=".song-item .title")
            private WebElement song;
    @FindBy(css=".btn-add-to")
            private WebElement addToButton;
    @FindBy(css="\".add-to .existing-playlists .playlist\"")
            private WebElement playlist1ScrollDown;

    public String getNotificationText(){
        return notificationText.getText();
    }
    public boolean isNotificationPopUpPresent () {
        return notificationText.isDisplayed();
    }

    public AllSongsPage clickSong () {
        song.click();
        return this;
    }
    public AllSongsPage clickAddToBtn () {
        addToButton.click();
        return this;
    }
    public AllSongsPage clickPlaylist1ScrollDown () {
        playlist1ScrollDown.click();
        return this;
    }
//   public void clickSong () {
//      song.click();
//   }
//   public void clickAddToBtn () {
//        addToButton.click();
//   }
//    public void clickPlaylist1ScrollDown () {
//        playlist1ScrollDown.click();
//    }

}
