package pages.marketpage;

import org.openqa.selenium.WebElement;
import utils.DriverUtils;

class NavigationBar {
    private String categoryXPath = "//ul[contains(@class,'topmenu__list')]//li[@data-department='%s']//a";

    NavigationBar() {

    }

    public void chooseCategoryName(String menuTab) {
        WebElement element = DriverUtils.findElement(String.format(categoryXPath, menuTab));
        element.click();
    }
}