package pages.productcategorypage;

public class Product {
    private String title;
    private String productNameXPath;
    private String descriptionXPath;
    private String priceXPath;

    public Product(String productName) {
        title = productName;
    }

    public String getName() {
        return title;
    }

    public String getShortDescription() {
        //TODO: implement this.
        return null;
    }

    public int getPrice() {
        //TODO: implement this.
        return 0;
    }
}
