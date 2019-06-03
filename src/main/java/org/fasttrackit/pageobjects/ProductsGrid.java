package org.fasttrackit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductsGrid {

    @FindBy(css = "h2.product-name >a")
    private List<WebElement> productNameContainers;


    public List<WebElement> getProductNameContainers() {
        return productNameContainers;
    }

    public List<String> getProductNames() {

        List<String> names = new ArrayList<>();
        for (WebElement nameContainers : productNameContainers) {
            String name = nameContainers.getText();
            names.add(name);
        }
        return names;
    }

    public WebElement getAddToWishlistButton(String productName, WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='product-info'and .//a[text()='" + productName + "']]//ul[@class='add-to-links']//a[text()='Add to Wishlist']"));
    }

    public void clickOnAddToWishlistButton(String productName, WebDriver driver) {
        getAddToWishlistButton(productName, driver).click();
    }

    public WebElement getAddToCartButton(String productName, WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='product-info'and .//a[text()='" + productName + "']]//button[@title='Add to Cart']"));
    }

    public void clickOnAddToCartButon(String productName, WebDriver driver) {
        getAddToCartButton(productName, driver).click();
    }

    public WebElement getAddToCartButtonFromWishlist(String productName, WebDriver driver) {
        return driver.findElement(By.xpath("//a[text()='Add to Cart' and //p[@class='product-name' and //a[text()='" + productName + "']]]"));
    }

    public void clickOnAddToCartButonFromWishlist(String productName, WebDriver driver) {
        getAddToCartButtonFromWishlist(productName, driver).click();
    }

    public WebElement getAdditionalAddToCartButton(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@class='map-popup-checkout']//button[@title='Add to Cart']"));
    }

    public void clickOnAdditionalAddToCartButon(WebDriver driver) {
        getAdditionalAddToCartButton(driver).click();
    }

    public WebElement getViewDetailsButton(String productName, WebDriver driver) {
        return driver.findElement(By.xpath(
                "//div[@class='product-info'and .//a[@title='" + productName + "']]//a[@class='button']"));
    }

    public void clickOnViewDetails(String productName, WebDriver driver) {
        getViewDetailsButton(productName, driver).click();
    }


    @FindBy(css = "a.list")
    private WebElement getViewAsListButton;

    public String clickOnListViewButton() {
        return getViewAsListButton.getText();
    }

    @FindBy(css = "a.grid")
    private WebElement getViewAsGridButton;


    public String clickOnGridViewButton() {
        return getViewAsGridButton.getText();

    }

    @FindBy(css = ".h1")
    private WebElement checkPage;

    public String HeaderCheckPage() {
        return checkPage.getText();

    }

    @FindBy(xpath = "//div[@class='count-container']/p/strong")
    private WebElement checkElementsOnThePage;

    public String checkTheNumberOfElements() {
        return checkElementsOnThePage.getText();

    }

}

