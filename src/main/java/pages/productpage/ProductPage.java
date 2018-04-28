package pages.productpage;

import org.openqa.selenium.WebElement;
import utils.DriverUtils;

public class ProductPage {
    private String productNameXPath = "//div[contains(@class, 'n-product-summary__headline')]//h1[contains(@class, 'title')]";

    public ProductPage() {

    }

    public String getProductName() {
        WebElement elem = DriverUtils.findElement(productNameXPath);
        return elem.getText();
    }
}
