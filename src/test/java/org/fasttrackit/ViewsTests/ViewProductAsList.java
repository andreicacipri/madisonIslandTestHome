package org.fasttrackit.ViewsTests;

import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.fasttrackit.pageobjects.SiteMenu;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ViewProductAsList extends TestBase {
    @Test
    public void ListView() {
        SiteMenu siteMenu = PageFactory.initElements(driver, SiteMenu.class);
        siteMenu.getMouseHover(driver);
        siteMenu.clickMouseHoverElectronics(driver);

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.clickOnListViewButton(driver);

        String newView = driver.findElement(By.cssSelector("strong.list")).getText();
        String correctView = "List";
        assertThat("the products are still in Grid view. ", newView.toUpperCase(), is(correctView.toUpperCase()));
    }

}
