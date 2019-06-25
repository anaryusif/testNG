package com.syntex.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntex.utils.BaseClass;

public class AddLocation extends BaseClass {
	@FindBy(xpath = "//*[@id=\"menu_admin_viewAdminModule\"]/a/span[2]")
    public WebElement admin;
    
    @FindBy(xpath = "//span[text()='Organization']")
    public WebElement organization;
    
    @FindBy(xpath = "//span[text()='Locations']")
    public WebElement locations;
    
    @FindBy(xpath = "//i[text()='add']")
    public WebElement addBtn;
    
    @FindBy(id = "name")
    public WebElement addName;
    
    @FindBy(xpath = "//div[@id='countryCode_inputfileddiv']//input")
    public WebElement countrySelect;
    
    @FindBy(id = "city")
    public WebElement city;
    
    @FindBy(id = "zipCode")
    public WebElement zip;
    
    @FindBy(xpath = "//a[text()='Save']")
    public WebElement saveBtn;
    
    public AddLocation() {
        PageFactory.initElements(driver, this);
    }
}