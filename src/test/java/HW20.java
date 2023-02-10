import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class HW20 extends BaseTest{

    @Test
    public void renamePlaylist () {

        String playlistName = generateRandomName();
        login("vikazhuk0904@gmail.com","te$t$tudent1");
        doubleClickChoosePlaylist();
        enterPlaylistName (playlistName);
        String newName = getPlaylistName();
        Assert.assertEquals(playlistName,newName);

    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public String getPlaylistName() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)>a")));
        String name = playlistElement.getText();
        return name;

    }

    public void enterPlaylistName(String name) {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));
        playlistInputField.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END), name);
        playlistInputField.sendKeys(Keys.ENTER);

    }

    public void doubleClickChoosePlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".playlist:nth-child(3)")));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlistElement).perform();
    }

}
