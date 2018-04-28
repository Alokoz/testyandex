package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Properties;

public class DriverUtils {
    private static Properties properties = TestProperties.getInstance().getProperties();
    private static final WebDriver INSTANCE = initWebDriver();

    private DriverUtils(){
        throw new AssertionError("This is static utils class. You are not allowed to invoke its constructor.");
    }

    public static WebDriver getWebDriverInstance() {
        return INSTANCE;
    }

    private static WebDriver initWebDriver() {
        switch (properties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                return new FirefoxDriver();
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                return new ChromeDriver();
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                return new ChromeDriver();
        }
    }

    public static WebElement findElement(String xPath) {
        return INSTANCE.findElement(By.xpath(xPath));
    }

    public static List<WebElement> findElements(String xPath) {
        return INSTANCE.findElements(By.xpath(xPath));
    }

    public static void click(WebElement elem) {
        try {
            elem.click();
        } catch (StaleElementReferenceException ex) {
            //TODO: search element one more time.
        }
    }
}
