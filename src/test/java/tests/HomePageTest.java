package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import utils.TestUtils;

public class HomePageTest extends BaseTest {
    @Test
    public void testLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user", "password");
        
        Assert.assertTrue(driver.findElement(By.cssSelector("p[data-testid='error-message']")).isDisplayed(), "Login failed.");
    }

    @Test
    public void testGoodLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("EasyUserName5", "IhateLoLEvenMore4");
        
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.leagueoflegends.com/hu-hu/", "Login Succesful");
    }

    @Test
    public void testLogout() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("EasyUserName5", "IhateLoLEvenMore4");

        String currentUrlAfterLogin = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlAfterLogin, "https://www.leagueoflegends.com/hu-hu/", "Login Successful");

        homePage.clickLogout();

        String mainPage = "https://www.leagueoflegends.com/hu-hu/";
        String currentUrlAfterLogout = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlAfterLogout, mainPage, "Logout Successful");
    }

    @Test
    public void testPageTitle() {
        String pageTitle = TestUtils.getPageTitle(driver);
        Assert.assertEquals(pageTitle, "League of Legends", "Page title does match League of Legends.");
    }
}
