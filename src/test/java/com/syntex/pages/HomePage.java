package com.syntex.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntex.utils.BaseClass;

public class HomePage extends BaseClass {
	@FindBy (xpath="//li[text()='Dashboard']")
			public WebElement dashboard;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
 
}
