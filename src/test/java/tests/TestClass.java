package tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.electronicpage.ElectronicaPage;
import pages.extendedsearchpage.ExtendedParametersPage;
import pages.mainpage.MainPage;
import pages.marketpage.MarketAppPage;
import pages.productcategorypage.Product;
import pages.productcategorypage.ProductCategoryPage;
import pages.productpage.ProductPage;
import utils.DriverUtils;
import utils.TestProperties;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestClass {

    private static final Properties properties = TestProperties.getInstance().getProperties();
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = DriverUtils.getWebDriverInstance();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Before
    public void setUpTest() {
        String baseUrl = "https://yandex.ru/";
        driver.get(baseUrl);
    }

    @Test
    public void testYandexTV() {
        new MainPage().selectAppCategory("Маркет");

        new MarketAppPage().chooseMenuTab("Электроника");

        new ElectronicaPage().chooseCategory("Аудио- и видеотехника -> Телевизоры");

        ProductCategoryPage page3 = new ProductCategoryPage();
        page3.setProductsPerPage(12);
        page3.goToExtendedSearch();

        ExtendedParametersPage page4 = new ExtendedParametersPage();
        page4.setProductLowPrice(20000);
        page4.selectManufacturers(Arrays.asList("Samsung", "LG"));
        page4.applyFilters();

        assertEquals(12, page3.getAllProductsOnPage().size());
        Product product = page3.getProductByOrderID(1);
        page3.searchFor(product.getName());
        ProductPage page5 = new ProductPage();
        assertEquals(product.getName(), page5.getProductName());
    }

//    @Test
    public void testYandexHeadPhones() {
        new MainPage().selectAppCategory("Маркет");

        new MarketAppPage().chooseMenuTab("Электроника");

        new ElectronicaPage().chooseCategory("Портативная техника -> Наушники и Bluetooth-гарнитуры");

        ProductCategoryPage page3 = new ProductCategoryPage();
        page3.setProductsPerPage(12);
        page3.goToExtendedSearch();

        ExtendedParametersPage page4 = new ExtendedParametersPage();
        page4.setProductLowPrice(20000);
        page4.selectManufacturers(Arrays.asList("Sennheiser"));
        page4.applyFilters();

        page3.selectViewMode("Список");
        assertEquals(12, page3.getAllProductsOnPage().size());
        Product product = page3.getProductByOrderID(1);
        page3.searchFor(product.getName());
        ProductPage page5 = new ProductPage();
        assertEquals(product.getName(), page5.getProductName());
    }
}
