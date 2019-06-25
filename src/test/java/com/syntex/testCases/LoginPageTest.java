package com.syntex.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntex.pages.HomePage;
import com.syntex.pages.LoginPage;
import com.syntex.pages.negativeLogin;
import com.syntex.utils.BaseClass;
import com.syntex.utils.CommonMethods;
import com.syntex.utils.ConfigsReader;

public class LoginPageTest extends BaseClass{
	@Test(enabled = true, groups = "smoke")
    public void loginToOrange() {
        logger = report.createTest("Positive Login");
        LoginPage login = new LoginPage();
        logger.info("Logging in with valid credentials");
        CommonMethods.sendText(login.username, "Admin");
        CommonMethods.sendText(login.password, "LCP@f03v");
        CommonMethods.justClick(login.btnLogin);
        logger.info("Verifying dashboard text is displayed");
        HomePage home = new HomePage();
        boolean isDisplayed = home.dashboard.isDisplayed();
        Assert.assertTrue(isDisplayed);
        logger.pass("Successfully logged in");
    }
    
    @Test(enabled = true, groups = "smoke")
    public void loginFindBy() {
        logger = report.createTest("Login verification2");
        LoginPage login = new LoginPage();
        CommonMethods.sendText(login.username, ConfigsReader.getProperty("username"));
        CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
        CommonMethods.justClick(login.btnLogin);
        
        HomePage home = new HomePage();
        boolean isDisplayed = home.dashboard.isDisplayed();
        Assert.assertTrue(isDisplayed);
        logger.pass("Login verification passed");
    }
    @Test(groups = "regression")
    public void negativeLogin() throws InterruptedException {
        LoginPage login = new LoginPage();
        CommonMethods.sendText(login.username, ConfigsReader.getProperty("username"));
        CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
        CommonMethods.justClick(login.btnLogin);
        
        negativeLogin signIn = new negativeLogin();
        boolean displayedError = signIn.error.isDisplayed();
        Assert.assertTrue(displayedError);
        Thread.sleep(2000);
    }
    
}