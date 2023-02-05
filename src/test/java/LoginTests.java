import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    public void NegativeLoginTests(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        loginSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void LoginSucceedTest() {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        loginSubmit();
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }
    @DataProvider(name = "getData")
    public Object[][] getData() throws Exception {
        Reader reader = Files.newBufferedReader(Paths.get(System.getProperty("user.dir") + "/src/test/resources/credentials.csv"));
        CSVReader csvReader = new CSVReader(reader);
        List<String[]> records = csvReader.readAll();
        Object[][] array = null;
        for (int i = 0; i < records.size(); i++) {

            Object[] row = records.get(i);
            if (Objects.isNull(array)) {
                array = new Object[records.size()][row.length];
            }
            array[i][0] = row[0];
            // System.out.println(array[i][column]);
            array[i][1] = row[1];
            // System.out.println(array[i][column]);

        }
        return array;

    }

    @Test(dataProvider = "getData")
    public void negLoginTests(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        loginSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void LoginWrongPasswordTest() {
        login("demo@class.com", "student");
        loginSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(submitLogin.isDisplayed());
    }

    @Test
    public void LoginEmptyPasswordTest() {
        enterEmail("demo@class.com");
        WebElement submitLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLogin.click();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Assert.assertTrue(submitLogin.isDisplayed());
        WebElement registationLink = driver.findElement(By.id("hel"));
        Assert.assertTrue(registationLink.isDisplayed(), "==== Registation link displayed ====");
    }

    @Test
    public void LoginWrongEmailTest() {
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