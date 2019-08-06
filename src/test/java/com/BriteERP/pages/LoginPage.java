package com.BriteERP.pages;

import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(id = "login")
    public WebElement usernameConsole;

    @FindBy(id = "password")
    public WebElement passwordConsole;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;



}
