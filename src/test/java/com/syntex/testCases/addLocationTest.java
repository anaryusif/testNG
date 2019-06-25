package com.syntex.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntex.pages.AddLocation;
import com.syntex.pages.LoginPage;
import com.syntex.utils.BaseClass;
import com.syntex.utils.CommonMethods;
import com.syntex.utils.Constants;
import com.syntex.utils.ExcelUtility;

public class addLocationTest extends BaseClass {
	@Test(dataProvider = "Locations", groups = "regression")
    public void location(String name, String country, String city, String zip) throws InterruptedException {
        AddLocation addLoc = new AddLocation();
        LoginPage logIn = new LoginPage();
        logIn.login("Admin", "LCP@f03veT");

        CommonMethods.justClick(addLoc.admin);
        Thread.sleep(1000);
        CommonMethods.justClick(addLoc.organization);
        Thread.sleep(1000);
        CommonMethods.justClick(addLoc.locations);
        Thread.sleep(1000);
        CommonMethods.justClick(addLoc.addBtn);
        Thread.sleep(1000);
        CommonMethods.sendText(addLoc.addName, name);
        CommonMethods.justClick(addLoc.countrySelect);
        Thread.sleep(1000);
      
        List<WebElement> countries = driver.findElements(By.tagName("li"));
        for (WebElement c : countries) {
            String list = c.getText();
            if (list.equals(country)) {
                c.click();
                break;
            }
        }
        Thread.sleep(2000);
        CommonMethods.sendText(addLoc.city, city);
        CommonMethods.sendText(addLoc.zip, zip);
        CommonMethods.justClick(addLoc.saveBtn);
        Thread.sleep(1000);

//        List<WebElement> table = driver.findElements(By.xpath("//table[@class = 'highlight bordered']/tbody/tr"));
//        for (int i = 1; i <= table.size(); i++) {
//            String data = driver.findElement(By.xpath("//table[@class = 'highlight bordered']/tbody/tr[" + i + "]"))
//                    .getText();
//            Assert.assertEquals(data, name);
//            
//        }
    }

    @DataProvider(name = "location input")
    public Object[][] inputLoc() {
        Object[][] data = new Object[3][4];

        data[0][0] = "Chipotle";
        data[0][1] = "Tajikistan";
        data[0][2] = "Mexico City";
        data[0][3] = "11111";

        data[1][0] = "McDonald's";
        data[1][1] = "Canada";
        data[1][2] = "Toronto";
        data[1][3] = "23456";

        data[2][0] = "Burger King";
        data[2][1] = "Spain";
        data[2][2] = "Madrid";
        data[2][3] = "56789";

        return data;

    }
    @DataProvider(name = "Locations")
    public Object[][] inputLocation(){
        ExcelUtility obj = new ExcelUtility();
        
        obj.openExcel(Constants.LOC_FILEPATH, "Locations");
        int row = obj.getRowNum();
        int cell = obj.getColNum(0);
        Object[][] data = new Object[row-1][cell];
        for(int i = 1; i < row; i++) {
            for(int j = 0; j < cell; j++) {
                String value = obj.getCellData(i, j);
                data[i-1][j] = value;
            }
        }
        return data;
        
    }
    

}