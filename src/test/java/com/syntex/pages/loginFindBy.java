package com.syntex.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntex.utils.BaseClass;

public class loginFindBy extends BaseClass{

	@FindBy(id = "txtUsername")
    public WebElement username;
    @FindBy(id = "txtPassword")
    public WebElement password;
    @FindBy(id = "btnLogin")
    public WebElement btnLogin;
    
    public loginFindBy() {
        PageFactory.initElements(driver, this);
    }
}

