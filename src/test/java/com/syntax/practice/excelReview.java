 package com.syntax.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excelReview {
	   @Test
	    public void readExcel() throws IOException {
		   
	        String xlPath = "src/test/resources/testdata/OrangeHrmData.xlsx";
	        
	            
	            FileInputStream fis = new FileInputStream(xlPath);
	            XSSFWorkbook workbook = new XSSFWorkbook(fis);
	            XSSFSheet sheet = workbook.getSheet("EmployeeDetails");
	            String value = sheet.getRow(6).getCell(0).toString();
	            System.out.println(value);
	            
	            workbook.close();
	            fis.close();
	            int rows = sheet.getPhysicalNumberOfRows();
	            int cols = sheet.getRow(0).getLastCellNum();
	            System.out.println("Number of rows " + rows + " and columns is " + cols);
	            
	            for(int i = 0; i<rows; i++) {
	                for(int j = 0; j<cols; j++) {
	                    String allValues = sheet.getRow(i).getCell(j).toString();
	                    System.out.print(allValues + "\t");
	                }
	                System.out.println();
	            }
	        }
	        
	    }