package com.syntex.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntex.utils.BaseClass;

public class negativeLogin extends BaseClass{
	@FindBy(id = "txtUsername")
    public WebElement username;
    @FindBy(id = "txtPassword")
    public WebElement password;
    @FindBy(id = "btnLogin")
    public WebElement btnLogin;
    
    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement error;
    
    public negativeLogin() {
        PageFactory.initElements(driver, this);
    }

}