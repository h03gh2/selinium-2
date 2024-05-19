package utils;

import org.openqa.selenium.WebDriver;

public class TestUtils {
    public static String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }
}
