import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW17 extends BaseTest {
    @Test
    public void addSongsToPlaylistTest() {
        enterEmail("vikazhuk0904@gmail.com");
        enterPassword("te$t$tudent1");
        loginSubmit();

        WebElement allSongsLink = driver.findElement(By.cssSelector(".songs.active"));
        allSongsLink.click();

       WebElement song = driver.findElement(By.cssSelector(".song-item .title"));
       String songName = song.getText();
       song.click();

       WebElement addToButton = driver.findElement(By.cssSelector(".btn-add-to"));
       addToButton.click();

        WebElement playlist1ScrollDown= driver.findElement(By.cssSelector("#songsWrapper .playlist"));
        playlist1ScrollDown.click();

        WebElement playlist1 = driver.findElement(By.cssSelector("#playlists .active"));
        playlist1.click();


    }


    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void loginSubmit() {
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
    }
}
