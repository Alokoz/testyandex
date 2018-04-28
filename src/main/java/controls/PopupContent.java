package controls;

import org.openqa.selenium.WebElement;
import utils.DriverUtils;

public class PopupContent {
    private String xPath = "//div[contains(@class, 'popup') and not(contains(@class, 'popup2'))]//div[contains(@class, 'select__list')]//span[text()='%s']";

    public void selectOption(String option) {
        WebElement elem = DriverUtils.findElement(String.format(xPath, option));
        elem.click();
    }
}
