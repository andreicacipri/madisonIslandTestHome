package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckMyAccountPage {
    @Test
    public void ThirdScenario() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test/");
        driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[@class='label']")).click();
        driver.findElement(By.xpath("//div[@class='links']//a[@title='My Account']")).click();

        String CreateAccountVariable ="LOGIN OR CREATE AN ACCOUNT";

        String product = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        assertThat("Succes messege is not display",product,is(CreateAccountVariable.toUpperCase()));

    }
}

