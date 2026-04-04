package pl.shopSeleniumTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.shopSeleniumTests.models.Customer;

public class AddressDetailsPage {

    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "billing_company")
    private WebElement companyInput;

    @FindBy(id = "billing_country")
    private WebElement selectCountryInput;

    @FindBy(id = "billing_address_1")
    private WebElement billingAddressInput;

    @FindBy(id = "billing_address_2")
    private WebElement billingAddressSecondInput;

    @FindBy(id = "billing_postcode")
    private WebElement billingPostalCodeInput;

    @FindBy(id = "billing_city")
    private WebElement billingCityInput;

    @FindBy(id = "billing_phone")
    private WebElement billingPhoneInput;

    @FindBy(id = "billing_email")
    private WebElement billingEmailInput;

    @FindBy(id = "order_comments")
    private WebElement billingOrderNotesInput;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    private WebDriver driver;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderDetailsPage fillFormDetails(Customer customer, String comments) {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        companyInput.sendKeys(customer.getCompanyName());
        Select countrySelect = new Select(selectCountryInput);
        countrySelect.selectByVisibleText(customer.getCountry());
        billingAddressInput.sendKeys(customer.getStreet());
        billingAddressSecondInput.sendKeys(customer.getFlatNumber());
        billingPostalCodeInput.sendKeys(customer.getPostalCode());
        billingCityInput.sendKeys(customer.getCity());
        billingPhoneInput.sendKeys(customer.getPhoneNumber());
        billingEmailInput.sendKeys(customer.getEmailAddress());
        billingOrderNotesInput.sendKeys(comments);
        placeOrderButton.click();

        return new OrderDetailsPage(driver);
    }
}
