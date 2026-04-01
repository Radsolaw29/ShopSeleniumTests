package pl.shopSeleniumTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    @FindBy(id = "reg_email")
    private WebElement regEmailInput;

    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;

    @FindBy(name = "register")
    private WebElement regButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement registerError;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerUserWithValidData(String email, String password) {
        fillRegisterUserForm(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserWithInvalidData(String email, String password) {
        fillRegisterUserForm(email, password);
        return this;
    }

    public LoggedUserPage logInWithValidData(String username, String password) {
        fillLoginUserForm(username, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage logInWithInvalidData(String username, String password) {
        fillLoginUserForm(username, password);
        return this;
    }

    public WebElement getError() {
        return registerError;
    }

    private void fillRegisterUserForm(String email, String password) {
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        regButton.click();
    }

    private void fillLoginUserForm(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
