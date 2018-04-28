package pages.mainpage.widgets;

import org.openqa.selenium.WebElement;
import utils.DriverUtils;

public class NavigationBar {
    private String navBarMenuItemxPath = "//div[@class='home-arrow__tabs']//div[@role='navigation']//a[text()='%s']";

    public NavigationBar() {

    }

    public void chooseAppCategory(String categoryName) {
        WebElement category = DriverUtils.findElement(String.format(navBarMenuItemxPath, categoryName));
        category.click();
    }
}
