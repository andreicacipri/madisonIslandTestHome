package org.fasttrackit;
import org.fasttrackit.pageobjects.SiteMenu;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class CheckMenPage extends TestBase{

    @Test
    public void MenPage() {
        SiteMenu siteMenu = PageFactory.initElements(driver, SiteMenu.class);
        String nameCategories = "WOMEN";
        siteMenu.getSiteMenuBar(nameCategories, driver);
        siteMenu.selectSiteMenuBar(nameCategories, driver);
        String selected = siteMenu.getSiteMenuBar(nameCategories, driver).getText();
        System.out.println("Opened " +siteMenu.NameCheckPage()+" page");
        assertThat("Succes messege is not display",siteMenu.NameCheckPage(),is(selected.toUpperCase()));
        driver.quit();
    }


}