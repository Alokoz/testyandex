package pages.mainpage.widgets;

import org.openqa.selenium.WebElement;
import utils.DriverUtils;

public class SearchAppWidget {
    private String searchFieldxPath = "//div[contains(@class, 'search2__input')]//input[@aria-label='Запрос']";
    private String searchButtonXPath = "//div[contains(@class, 'search2__button')]//button[contains(@class, 'button_theme_websearch')]//span[text()='Найти']";

    public void search(String query) {
        enterQuery(query);
        clickSearchButton();
    }

    private void enterQuery(String query) {
        WebElement searchField = DriverUtils.findElement(searchFieldxPath);
        searchField.sendKeys(query);
    }

    private void clickSearchButton() {
        WebElement searchButton = DriverUtils.findElement(searchButtonXPath);
        searchButton.click();
    }
}
