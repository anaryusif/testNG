package com.syntex.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntex.utils.BaseClass;

public class AddEmployee extends BaseClass{
	@FindBy(xpath = "//span[text()='PIM']")
    public WebElement pim;
    
    @FindBy(xpath = "//span[text()='Add Employee']")
    public WebElement addEmployee;
    
    @FindBy(id = "firstName")
    public WebElement firstName;
    @FindBy(id="middleName")
   public WebElement middleName;
    
    @FindBy(id = "lastName")
    public WebElement lastName;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//input")
   public WebElement location;
    
    @FindBy(xpath = "//div[@id='location_inputfileddiv']//ul")
    public WebElement loc;
    @FindBy(xpath="//input[@id='chkLogin']")
   public WebElement createLoginDetails;

   @FindBy(id="systemUserSaveBtn")
   public WebElement saveBtn;

   @FindBy(xpath="//span[@id='pim.navbar.employeeName']")
   public WebElement empCheck;
    public AddEmployee() {
        PageFactory.initElements(driver, this);
    }
    
}