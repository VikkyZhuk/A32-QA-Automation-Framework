package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By notificationText = By.cssSelector("div.success.show");
    By song = By.cssSelector(".song-item .title");
    By addToButton = By.cssSelector(".btn-add-to");
    By playlist1ScrollDown= By.cssSelector(".add-to .existing-playlists .playlist");


    public String getNotificationText(){
//        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return driver.findElement(notificationText).getText();
    }

    public boolean isNotificationPopUpPresent () {
//        WebElement notificationText = driver.findElement(By.cssSelector("div.success.show"));
        return driver.findElement(notificationText).isDisplayed();
    }

   public void clickSong () {
        driver.findElement(song).click();
   }

   public void clickAddToBtn () {
        driver.findElement(addToButton).click();
   }

    public void clickPlaylist1ScrollDown () {
        driver.findElement(playlist1ScrollDown).click();
    }

}
