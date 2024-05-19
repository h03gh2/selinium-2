package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvancedTest extends BaseTest {
    @Test
    public void testHover() {
        WebElement elementToHover = driver.findElement(By.xpath("//p[contains(text(), 'Hírek')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        
        WebElement dropdownMenu = driver.findElement(By.xpath("//div[@class='dropdown-menu']"));
        Assert.assertTrue(dropdownMenu.isDisplayed(), "Dropdown menu is displayed.");
    }

    @Test
    public void testHistoryNavigation() {
        driver.navigate().to("https://www.leagueoflegends.com/hu-hu/how-to-play/");
        String previousPageUrl = driver.getCurrentUrl();
        driver.navigate().to("https://www.leagueoflegends.com/hu-hu/");
        driver.navigate().back();
        String currentPageUrl = driver.getCurrentUrl();
        
        Assert.assertEquals(previousPageUrl, currentPageUrl, "Browser did navigate back");
    }
}
