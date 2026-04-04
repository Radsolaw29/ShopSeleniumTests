package pl.shopSeleniumTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {

    @FindBy(xpath = "//h2[contains(., 'Java Selenium WebDriver')]")
    private WebElement javaCourseLink;

    private WebDriver driver;

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage openProduct() {
        javaCourseLink.click();
        return new ProductPage(driver);
    }
}
