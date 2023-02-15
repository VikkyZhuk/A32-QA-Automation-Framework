import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class HW22 extends BaseTest{

    @Test

    public void loginValidEmailPasswordTest (){
        LoginPage loginPage = new LoginPage (driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void registrationNavigationTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationBtn();
        Assert.assertTrue(loginPage.getRegistrationButton().isDisplayed());
    }

    @Test
    public void addSongsToPlaylistTest()  {
       LoginPage loginPage = new LoginPage(driver);
       HomePage homePage = new HomePage(driver);
       AllSongsPage allSongsPage = new AllSongsPage(driver);

       loginPage.login();
       homePage.clickAllSongsLink();
       allSongsPage.clickSong();
       allSongsPage.clickAddToBtn();
       allSongsPage.clickPlaylist1ScrollDown();

       Assert.assertTrue(allSongsPage.isNotificationPopUpPresent());

    }

    @Test

    public void playSong (){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        homePage.clickPlayBtn();

        Assert.assertTrue(homePage.pauseBtnPresence());

    }

    @Test
    public void deletePlaylistTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();

        List <WebElement> playlists = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".playlist.playlist>a")));
        int playlistNumber=playlists.size();
        playlists.get(playlistNumber-1).click();
        String name = playlists.get(playlistNumber-1).getText();
        System.out.println(name);

        homePage.clickDeletePlaylistBtn();

        String notificationText = "Deleted playlist \"" + name + ".\"";

        System.out.println(notificationText);

        String notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success.show"))).getText();
        System.out.println(notification);

        Assert.assertEquals(notificationText, notification);
    }

    @Test
    public void renamePlaylist () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        String playlistName = homePage.generateRandomName();
        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterPlaylistName (playlistName);
        String newName = homePage.getPlaylistName();
        Assert.assertEquals(playlistName,newName);

    }











    }
