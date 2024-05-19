package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By loginButton = By.xpath("//a[contains(text(),'Bejelentkezés')]");
    private By logoutButton = By.xpath("//a[contains(text(),'Kijelentkezés')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void clickLogout() {
        click(logoutButton);
    }
}
