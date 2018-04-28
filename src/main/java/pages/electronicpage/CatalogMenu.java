package pages.electronicpage;

import org.openqa.selenium.WebElement;
import utils.DriverUtils;

public class CatalogMenu {
    private String categoryXPath = "//div[contains(@class, 'catalog-menu__item')]//a[contains(@class, 'catalog-menu__title')][text()='%s']";
    private String subCategoryXPath = "//div[contains(@class, 'catalog-menu__item')][.//a[contains(@class, 'catalog-menu__title')][text()='%s']]//div[contains(@class, 'catalog-menu__list')]//a[text()='%s']";

    public void chooseCategory(String category) {
        String[] categories = category.split(" -> ");
        if (categories.length > 2) {
            throw new IllegalArgumentException("Path to category should not exceed 2 parts.");
        }
        CatalogMenu catalogMenu = new CatalogMenu();
        if (categories.length == 2) {
            catalogMenu.chooseSubCategory(categories[0], categories[1]);
        }
        else {
            catalogMenu.chooseMainCategory(categories[0]);
        }
    }

    private void chooseMainCategory(String mainCategory) {
        WebElement elem = DriverUtils.findElement(String.format(categoryXPath, mainCategory));
        elem.click();
    }

    private void chooseSubCategory(String mainCategory, String subCategory) {
        WebElement elem = DriverUtils.findElement(String.format(subCategoryXPath, mainCategory, subCategory));
        elem.click();
    }
}
