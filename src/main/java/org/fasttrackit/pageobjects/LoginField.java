package org.fasttrackit.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginField {

    @FindBy(id = "email")
    private WebElement emailAdress;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(xpath = "//button[@title='Login']")
    private WebElement registerButton;

    public void completeLogin(String emailAdressVar,String passwordVar){

        emailAdress.sendKeys(emailAdressVar);
        password.sendKeys(passwordVar);
        registerButton.click();


    }

    }
