package com.syntex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntex.utils.BaseClass;
import com.syntex.utils.CommonMethods;

public class LoginPage extends BaseClass {
	public WebElement username = driver.findElement(By.id("txtUsername"));
    public WebElement password = driver.findElement(By.id("txtPassword"));
    public WebElement btnLogin = driver.findElement(By.id("btnLogin"));
    
    public void login(String uname, String pwd) {
       CommonMethods.sendText(username, uname);
       CommonMethods.sendText(password, pwd);
       CommonMethods.justClick(btnLogin);
   }
    
}
