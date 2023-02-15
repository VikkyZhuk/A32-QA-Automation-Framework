package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By avatarIcon = By.cssSelector("img.avatar");
    By allSongsLink = By.cssSelector(".menu .songs");
    By playBtn = By.cssSelector("[data-testid='play-btn']");
    By pauseBtn = By.cssSelector("[data-testid='pause-btn']");
    By deletePlaylistBtn = By.cssSelector(".btn-delete-playlist");
    By playlistElement = By.cssSelector(".playlist:nth-child(3)");

    public void doubleClickPlaylist (){
        doubleClick(driver.findElement(playlistElement));
    }

    public WebElement getUserAvatar (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(avatarIcon));
    }

    public void clickAllSongsLink(){
        driver.findElement(allSongsLink).click();
    }

    public void clickPlayBtn () {
        actions.moveToElement(driver.findElement(playBtn)).perform();
        driver.findElement(playBtn).click();
    }

    public boolean pauseBtnPresence (){
        return driver.findElement(pauseBtn).isDisplayed();
    }
    public void clickDeletePlaylistBtn (){
        driver.findElement(deletePlaylistBtn).click();
    }

    public void enterPlaylistName(String name) {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        playlistInputField.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);

    }

    public String getPlaylistName() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)>a")));
        String name = playlistElement.getText();
        return name;

    }








}
