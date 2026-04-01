package pl.shopSeleniumTests.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.shopSeleniumTests.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        int random = (int) (Math.random() * 1000);

        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserWithValidData("test" + random + "@wp.pl", "password12!CADB!?")
                .getDashboardLink();

        Assert.assertTrue(dashboardLink.isDisplayed());
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void registerUserWithExistingEmailTest() {
        WebElement registerError = new HomePage(driver)
                .openMyAccountPage()
                .registerUserWithInvalidData("test@wp.pl", "password12!CACCB!?")
                .getError();

        Assert.assertTrue(registerError.getText().contains("An account is already registered with your email address."));
    }
}
