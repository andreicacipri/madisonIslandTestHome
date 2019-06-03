package org.fasttrackit.CheckTests;

import org.fasttrackit.TestBase;
import org.fasttrackit.pageobjects.ProductsGrid;
import org.fasttrackit.pageobjects.SiteMenu;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckNumberOfElementsFromElectronicPage extends TestBase {
    @Test
    public void CheckNumberOfElements() {
        SiteMenu siteMenu = PageFactory.initElements(driver, SiteMenu.class);
        siteMenu.getMouseHover(driver);
        siteMenu.clickMouseHoverElectronics(driver);

        ProductsGrid ElementsNumber = PageFactory.initElements(driver, ProductsGrid.class);
        String numberElements = ElementsNumber.checkTheNumberOfElements();
        numberElements = numberElements.replaceAll("\\D+", "");
        int intNumberElements = Integer.parseInt(numberElements);

        assertThat("The number of products are not correct", ElementsNumber.getProductNames().size(), is(intNumberElements));
        driver.quit();
    }
}
