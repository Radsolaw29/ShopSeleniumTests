package pl.shopSeleniumTests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.shopSeleniumTests.models.Customer;
import pl.shopSeleniumTests.pages.HomePage;
import pl.shopSeleniumTests.pages.OrderDetailsPage;

public class BuyProductTest extends BaseTest {

    @Test
    public void buyProductTest() {
        Customer customer = new Customer();

        OrderDetailsPage orderDetails = new HomePage(driver)
                .openShopPage()
                .openProduct()
                .addProductToCart()
                .openCartPage()
                .openAddressDetailsPage()
                .fillFormDetails(customer, "Some random comment");

        Assert.assertEquals(orderDetails.getOrderNotice().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderDetails.getProductName().getText(), "Java Selenium WebDriver × 1");
    }
}
