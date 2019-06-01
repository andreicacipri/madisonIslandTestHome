package org.fasttrackit;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.fasttrackit.pageobjects.SiteMenu;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckAddToCartButtonFromElectronicsPage extends TestBase {
    @Test
    public void CheckAddToCartButton() {
        SiteMenu siteMenu = PageFactory.initElements(driver, SiteMenu.class);
        siteMenu.getMouseHover(driver);
        siteMenu.clickMouseHoverElectronics(driver);

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        String productName = "Madison 8GB Digital Media Player";
        productsGrid.getAddToCartButton(productName,driver);
        productsGrid.clickOnAddToCartButon(productName,driver);
        driver.manage().timeouts().implicitlyWait(AppConfig.getTimeout(), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(AppConfig.getTimeout(), TimeUnit.SECONDS);
        String product = driver.findElement(By.xpath("//tbody //tr//td//h2//a")).getText();
        assertThat("Add to cart not succeeded",product,is(productName.toUpperCase()));
    }
}

