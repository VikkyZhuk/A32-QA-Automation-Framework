import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class HW23 extends BaseTest{

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
        allSongsPage.clickSong()
                 .clickAddToBtn()
                 .clickPlaylist1ScrollDown();

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

    @Test (priority = 1)
    public void deletePlaylistTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.playlistSize();
        homePage.playlistLast().click();

        String name=homePage.playlistLast().getText();
        System.out.println(name);

        homePage.clickDeletePlaylistBtn()
                .notificationDeletePlaylist();

        String notificationText = "Deleted playlist \"" + name + ".\"";

        Assert.assertEquals(notificationText, homePage.notificationDeletePlaylist());
    }

    @Test
    public void renamePlaylist () {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        String playlistName = homePage.generateRandomName();
        loginPage.login();
        homePage.doubleClickPlaylist()
                .enterPlaylistName(playlistName);
        String newName = homePage.getPlaylistName();
        Assert.assertEquals(playlistName,newName);

    }
}
