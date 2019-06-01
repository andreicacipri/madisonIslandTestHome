package org.fasttrackit.ViewsTests;

import org.fasttrackit.AppConfig;
import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.LoginField;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.fasttrackit.pageobjects.SiteMenu;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckAddToWhislistButton extends TestBase {
    @Test
    public void AddToWhislistButton() {

        driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']")).click();

        SiteMenu AccountMenu = PageFactory.initElements(driver, SiteMenu.class);
        String nameSubCategories = "Log In";
        AccountMenu.selectAccountMenuBar(nameSubCategories,driver);
        String currentPage = AccountMenu.getAccountMenuBar(nameSubCategories,driver).getAttribute("title");
        System.out.println("Opened "+currentPage+" page!");

        LoginField registerField = PageFactory.initElements(driver, LoginField.class);
        String emailAdressVar = "CipA@yahoo.com";
        String passwordVar ="car56pole";

        registerField.completeLogin(emailAdressVar,passwordVar);
        driver.manage().timeouts().setScriptTimeout(AppConfig.getTimeout(), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(AppConfig.getTimeout(),TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(AppConfig.getTimeout(),TimeUnit.SECONDS);

        SiteMenu siteMenu = PageFactory.initElements(driver, SiteMenu.class);
        siteMenu.getMouseHover(driver);
        siteMenu.clickMouseHoverElectronics(driver);

        ProductsGrid Whislist = PageFactory.initElements(driver, ProductsGrid.class);
        String productName = "Madison Earbuds";
        Whislist.clickOnAddToWishlistButton(productName,driver);
        driver.manage().timeouts().setScriptTimeout(AppConfig.getTimeout(), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(AppConfig.getTimeout(),TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(AppConfig.getTimeout(),TimeUnit.SECONDS);


        String reviewVariable ="Madison Earbuds has been added to your wishlist.";

       String product = driver.findElement(By.xpath("//li[@class='success-msg']//li//span[contains(text(), 'Madison Earbuds has been added to your wishlist.')]")).getText();
        System.out.println(product);
       assertThat("Product was not added to wish list.",product.toUpperCase(),containsString(reviewVariable.toUpperCase()));

    }
}
