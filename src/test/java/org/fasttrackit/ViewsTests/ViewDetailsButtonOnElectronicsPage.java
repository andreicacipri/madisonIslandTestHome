package org.fasttrackit.ViewsTests;

import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.fasttrackit.pageobjects.SiteMenu;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ViewDetailsButtonOnElectronicsPage extends TestBase {
    @Test
    public void ViewDetailsOnProduct() {
        SiteMenu siteMenu = PageFactory.initElements(driver, SiteMenu.class);
        siteMenu.getMouseHover(driver);
        siteMenu.clickMouseHoverElectronics(driver);

        ProductsGrid ViewDetails = PageFactory.initElements(driver, ProductsGrid.class);
        String productName = "MP3 Player with Audio";
        ViewDetails.getViewDetailsButton(productName, driver);
        ViewDetails.clickOnViewDetails(productName, driver);
        String selectedDetailsProduct = ViewDetails.HeaderCheckPage();
        System.out.println("Opened details page for " + selectedDetailsProduct + " .");
        assertThat("View Details page for this product not opened", selectedDetailsProduct, is(productName.toUpperCase()));
        //driver.quit();
    }
}
