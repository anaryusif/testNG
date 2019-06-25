package com.syntex.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntex.pages.AddEmployee;
import com.syntex.pages.LoginPage;
import com.syntex.utils.BaseClass;
import com.syntex.utils.CommonMethods;
import com.syntex.utils.Constants;
import com.syntex.utils.ExcelUtility;

public class AddEmployeeTest extends BaseClass {
    @Test(dataProvider = "employee data", groups = "regression")
    public void addEmployee(String fName, String mName, String lName, String location) throws InterruptedException {
        AddEmployee addEmp = new AddEmployee();
        LoginPage logIn = new LoginPage();
        logIn.login("Admin", "LCP@f03veT");
//      Thread.sleep(1000);
//      
        CommonMethods.justClick(addEmp.pim);
        
        CommonMethods.justClick(addEmp.addEmployee);
        
        CommonMethods.sendText(addEmp.firstName, fName);
        
        CommonMethods.sendText(addEmp.middleName, mName);
        CommonMethods.sendText(addEmp.lastName, lName);
        
        CommonMethods.justClick(addEmp.location);
        
        CommonMethods.selectList(addEmp.loc, location);
        CommonMethods.justClick(addEmp.saveBtn);
        // verify employee is added
        CommonMethods.waitForElementBeClickable(addEmp.empCheck, 20);
        String verifText = addEmp.empCheck.getText();
        System.out.println(verifText);
        Assert.assertEquals(verifText, fName + " " + lName);
    }
    @DataProvider(name = "employee details")
    public Object[][] getData() {
        Object[][] data = new Object[3][4];
        // 1 set
        data[0][0] = "John";
        data[0][1] = "Snow";
        data[0][2] = "White";
        data[0][3] = "HQ";
        // 2 set
        data[1][0] = "Jane";
        data[1][1] = "Rain";
        data[1][2] = "Yellow";
        data[1][3] = "West Office";
        // 3 set
        data[2][0] = "Arya";
        data[2][1] = "Sunny";
        data[2][2] = "Blue";
        data[2][3] = "North Office";
        return data;
    }
    @DataProvider(name = "employee data")
    public Object[][] getEmpData() {
        ExcelUtility obj = new ExcelUtility();
        obj.openExcel(Constants.XL_FILEPATH, "Locations");
        int row = obj.getRowNum();
        int cell = obj.getColNum(0);
        Object[][] data = new Object[row-1][cell];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < cell; j++) {
                String value1 = obj.getCellData(i, j);
                data[i-1][j] = value1;
            }
        }
        return data;
    }
}