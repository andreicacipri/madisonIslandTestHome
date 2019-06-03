package org.fasttrackit.ViewsTests;

import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.fasttrackit.pageobjects.SiteMenu;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ViewProductAsGrid extends TestBase {
    @Test
    public void GridView() {

        SiteMenu siteMenu = PageFactory.initElements(driver, SiteMenu.class);
        siteMenu.getMouseHover(driver);
        siteMenu.clickMouseHoverElectronics(driver);

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);
        productsGrid.clickOnListViewButton();

        productsGrid.clickOnGridViewButton();
        String actualView = driver.findElement(By.cssSelector("strong.grid")).getText();
        String correctView = "Grid";

        assertThat("the products are still in List view. ", actualView.toUpperCase(), is(correctView.toUpperCase()));
    }

}
