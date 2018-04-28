package pages.extendedsearchpage;

import org.openqa.selenium.WebElement;
import utils.DriverUtils;

import java.util.List;

public class ExtendedParametersPage {
    private String lowPriceXPath = "//input[contains(@name, 'glf-pricefrom-var')]";
    private String highPriceXPath = "//input[contains(@name, 'glf-priceto-var')]";
    private String manufacturersXPath = "//div[contains(@class, 'n-filter-block')][./div[contains(@class, 'n-filter-block__header')]//span[contains(@class, 'title') and text()='Производитель']]//div[contains(@class, 'n-filter-block__body')]//div[contains(@class, 'n-filter-block__list')]//label[contains(@class, 'checkbox__label') and text()='%s']";
    private String applyFilterButton = "//div[contains(@class, 'n-filter-panel-extend__button-bar')]//a[@role='button'][.//span[contains(@class, 'button__text') and text()='Показать подходящие']]";
    private String resetFiltersButton = "//div[contains(@class, 'n-filter-panel-extend__button-bar')]//a[@role='button']//span[contains(@class, 'button__text') and contains(text(), 'Сбросить фильтры')]";

    public ExtendedParametersPage() {

    }

    public void setProductLowPrice(int price) {
        WebElement elem = DriverUtils.findElement(lowPriceXPath);
        elem.sendKeys(String.valueOf(price));
    }

    public void setProductHighPrice(int price) {
        WebElement elem = DriverUtils.findElement(highPriceXPath);
        elem.sendKeys(String.valueOf(price));
    }

    public void selectManufacturers(List<String> manufacturers) {
        for (String manName : manufacturers) {
            WebElement elem = DriverUtils.findElement(String.format(manufacturersXPath, manName));
            elem.click();
        }

    }

    public void selectManufacturer() {
        //TODO: implement this if there is a need to select only one manufacturer.
    }

    public void applyFilters() {
        WebElement elem = DriverUtils.findElement(applyFilterButton);
        elem.click();
    }

    public void resetFilters() {
        WebElement elem = DriverUtils.findElement(resetFiltersButton);
        elem.click();
    }
}
