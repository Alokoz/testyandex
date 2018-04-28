package pages.productcategorypage;

import controls.PopupContent;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;
import utils.WaitUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryPage {
    private static final int SHORT = 12;
    private static final int LONG = 48;

    private String productsXPath = "//div[contains(@class, 'n-snippet-list')]/div[contains(@class, 'n-snippet-card2') and starts-with(@data-id, 'model')]//div[contains(@class, 'n-snippet-card2__title')]/a";
    private String searchBarXPath = "//form[contains(@class, 'header2__search')]//span[contains(@class, 'search2__input')]//input[@id='header-search']";
    private String searchButtonXPath = "//form[contains(@class, 'header2__search')]//span[contains(@class, 'search2__button')]//button//*[text()='Найти']";
    private String viewModeXPath = "//div[contains(@class, 'view-switcher')]//label/input[@value='%s']";
    public ProductCategoryPage() {
    }

    public void getNextPage() {
        //TODO: implement this.
    }

    public void getPreviosPage() {
        //TODO: implement this.
    }

    public Product getProduct(String productName) {
        return new Product(productName);
    }

    public List<Product> getAllProductsOnPage() {
        List<Product> products = new ArrayList<>();
        List<WebElement> elements = DriverUtils.findElements(productsXPath);
        for (WebElement elem : elements) {
            products.add(new Product(elem.getText()));
        }
        return products;
    }

    public void goToExtendedSearch() {
        WebElement elem = DriverUtils.findElement("//div[contains(@class, 'search-layout')]//a[text()='Перейти ко всем фильтрам']");
        elem.click();
    }

    public Product getProductByOrderID(int i) {
        WebElement elem = DriverUtils.findElement(productsXPath + String.format("[%d]", i));
        return new Product(elem.getText());
    }

    public void searchFor(String query) {
        enterQuery(query);
        clickSearchButton();
    }

    public void setProductsPerPage(int pages) {
        WebElement elem = DriverUtils.findElement("//button[contains(@class, 'button_size_s')]");
        elem.click();
        PopupContent popUp = new PopupContent();
        switch (pages) {
            case SHORT:
                popUp.selectOption(String.format("Показывать по %d", SHORT));
                break;
            case LONG:
                popUp.selectOption(String.format("Показывать по %d", LONG));
                break;
            default:
                throw new InvalidArgumentException("Invalid quantity of products to show per page.");
        }
        waitForFilterToApply();
    }

    public void selectViewMode(String viewMode) {
        WebElement elem;
        switch (viewMode) {
            case "Список":
                elem = DriverUtils.findElement(String.format(viewModeXPath, "list"));
                elem.click();
                break;
            case "Блок":
                elem = DriverUtils.findElement(String.format(viewModeXPath, "grid"));
                elem.click();
                break;
            default:
                throw new InvalidArgumentException(String.format("There is no view option with name '%s'", viewMode));
        }
    }

    private void waitForFilterToApply() {
        WaitUtils.waitForInvisible("//div[contains(@class, 'n-filter-applied-results__content')]//div[contains(@class, 'preloadable__preloader preloadable__preloader_visibility_visible preloadable__paranja')]");
    }

    private void enterQuery(String query) {
        WebElement elem = DriverUtils.findElement(searchBarXPath);
        elem.sendKeys(query);
    }

    private void clickSearchButton() {
        WebElement elem = DriverUtils.findElement(searchButtonXPath);
        elem.click();
    }
}
