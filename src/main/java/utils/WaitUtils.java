package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    private static final WebDriver driver = DriverUtils.getWebDriverInstance();
    private static WebDriverWait wait = new WebDriverWait(driver, 10);

    public static void waitForInvisible(String xPath) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xPath)));
    }
}
