import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.UUID;

public class LoginTests extends BaseTest {

    @DataProvider(name="IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][]{
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""},
        };
    }

    @Test(dataProvider = "IncorrectLoginProviders")
    public void negativeLoginTests(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        loginSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginSucceedTest() {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void loginWrongPasswordTest() {
        login("demo@class.com", "student");
        loginSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLogin.isDisplayed());
    }

    @Test
    public void loginEmptyPasswordTest() {
        enterEmail("demo@class.com");
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Assert.assertTrue(submitLogin.isDisplayed());
        WebElement registationLink = driver.findElement(By.id("hel"));
        Assert.assertTrue(registationLink.isDisplayed(), "==== Registation link displayed ====");
    }

    @Test
    public void loginWrongEmailTest() {
        enterEmail("dem@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLogin.isDisplayed());
        WebElement registationLink = driver.findElement(By.id("hel"));
        String link = registationLink.getText();
        System.out.println("==== This is our link text ==== " + link);
    }

    @Test
    public void changeProfileNameTest() {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        openUserProfile();
        String user = generateRandomName();
        setName(user);
        setPassword();
        saveProfile();
        getSuccessBanner();
        Assert.assertEquals(getUsername(), user);
    }

    private WebElement getSuccessBanner() {
        WebElement successBanner = driver.findElement(By.cssSelector(".success"));
        return successBanner;
    }

    private void openUserProfile() {
        WebElement profile = driver.findElement(By.cssSelector(".view-profile"));
        profile.click();
    }


    private String getUsername() {
        String userName = driver.findElement(By.cssSelector(".view-profile .name")).getText();
        return userName;
    }

    public void setName(String newName) {
        WebElement nameInput = driver.findElement(By.cssSelector("#inputProfileName"));
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(newName);
    }

    public void setPassword() {
        WebElement passwordInput = driver.findElement(By.cssSelector("#inputProfileCurrentPassword"));
        passwordInput.click();
        passwordInput.sendKeys("te$t$tudent");
    }

    public void saveProfile() {
        WebElement saveButton = driver.findElement(By.cssSelector(".btn-submit"));
        saveButton.click();
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");//
    }


}
//        Email("demo@class.com");
//        Password("te$t$tudent");