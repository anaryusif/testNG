package com.syntex.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass{
    /**
     * This method will select a specified value from a drop down
     * 
     * @author Syntax
     * @param Select element, String text
     */
    public static void selectValueFromDD(WebElement element, String text) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        boolean isSelected = false;
        for (WebElement option : options) {
            String optionText = option.getText();
            if (optionText.equals(text)) {
                select.selectByVisibleText(text);
                System.out.println("Option with text " + text + " is selected");
                isSelected = true;
                break;
            }
        }
        if (!isSelected) {
            System.out.println("Option with text +" + text + "is not available");
        }
    }
    /**
     * This method will select a specified value from a drop down by its index
     * 
     * @author Syntax
     * @param Select element, int index
     */
    public static void selectValueFromDD(WebElement element, int index) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        if (options.size() > index) {
            select.selectByIndex(index);
        } else {
            System.out.println("Invalid index has been passed");
        }
    }
    public static void sendText(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
    /**
     * Method will accept alert
     * 
     * @throws NoAlertPresentException if alert is not present
     */
    public static void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("Alert was not present");
        }
    }
    /**
     * Method will dismiss alert
     * 
     * @throws NoAlertPresentException if alert is not present
     */
    public static void dismissAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            System.out.println("Alert was not present");
        }
    }
    /**
     * Method will get text of an alert
     * 
     * @throws NoAlertPresentException if alert is not present
     * @return String text
     */
    public static String getAlertText() {
        try {
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        } catch (NoAlertPresentException e) {
            System.out.println("Alert was not present");
            return null;
        }
    }
    /**
     * Method that will switch control to the specified frame
     * 
     * @param frame id or frame name
     */
    public static void switchToFrame(String idOrName) {
        try {
            driver.switchTo().frame(idOrName);
        } catch (NoSuchFrameException e) {
            System.out.println("Frame is not present");
        }
    }
    /**
     * Method that will switch control to the specified frame
     * 
     * @param frame element
     */
    public static void switchToFrame(WebElement element) {
        try {
            driver.switchTo().frame(element);
        } catch (NoSuchFrameException e) {
            System.out.println("Frame is not present");
        }
    }
    /**
     * Method that will switch control to the specified frame
     * 
     * @param frame index
     */
    public static void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (NoSuchFrameException e) {
            System.out.println("Frame is not present");
        }
    }
    /**
     * Method that will click on a radio button
     * 
     * @param List<WebElement> element
     */
    public static void radioButtonClick(List<WebElement> element, String valueToSelect) {
        for (WebElement radioButton : element) {
            if (radioButton.isEnabled()) {
                if (radioButton.getText().equals(valueToSelect))
                    radioButton.click();
            } else {
                System.out.println("Radio Button is disabled");
            }
        }
    }
    public static void checkBoxClick(List<WebElement> element, String valueToSelect) {
        for(WebElement checkBoxSelect: element) {
            if(checkBoxSelect.isEnabled()) {
                if(checkBoxSelect.getText().equals(valueToSelect))
                    checkBoxSelect.click();
            }
                
        }
    }
    public static void selectCalendarDate(List<WebElement> element, String date) {
        for(WebElement pickDate: element) {
            if(pickDate.isEnabled()) {
                if(pickDate.getText().equals(date))
                    pickDate.click();
            }
            else {
                System.out.println("Date is not available");
            }
                
        }
    }
    
        
    
    public static void justClick(WebElement element) {
        element.click();
    }
    public static void quit() {
        driver.quit();
    }
    
    /**
     * Method that will wait for element to be visible
     * 
     * @param WebElement element, int time
     */
    public static void waitForElementBeVisible(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForElementBeVisible(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void waitForElementBeClickable(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    } 
    public static void waitForElementBeClickable(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public static String takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File scr = ts.getScreenshotAs(OutputType.FILE);
        String dest=System.getProperty("user.dir")+"/target/screenshots/"+ fileName + ".png";
        
        try {
            FileUtils.copyFile(scr, new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to take screesnhot");
        }
        return dest;
    }
    
    public static void selectList(WebElement element, String text) {
        List<WebElement> list = element.findElements(By.tagName("li"));
        for(WebElement li: list) {
            String t = li.getText();
            if(t.equals(text)) {
                li.click();
                break;
            }
        }
    }
    
    
}