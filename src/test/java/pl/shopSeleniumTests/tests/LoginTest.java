package pl.shopSeleniumTests.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.shopSeleniumTests.pages.HomePage;

public class LoginTest extends BaseTest {

    @Test
    public void logInUserWithValidData() {
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .logInWithValidData("test443@wp.pl", "password12!CADB!?")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void logInUserWithInvalidData() {
        WebElement loginError = new HomePage(driver)
                .openMyAccountPage()
                .logInWithInvalidData("faddasfa@wp.pl", "vsvsfgbsfgs")
                .getError();

        Assert.assertTrue(loginError.getText().contains("Incorrect username or password."));
    }
}
