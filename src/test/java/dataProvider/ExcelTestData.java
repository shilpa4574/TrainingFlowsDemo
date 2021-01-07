package dataProvider;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;


public class ExcelTestData {

       public String getUsername() throws Throwable{
    	 //Create an object of File class to open xlsx file
           File file =    new File("C:\\Selenium\\TestData.xlsx");
           
           //Create an object of FileInputStream class to read excel file
           FileInputStream inputStream = new FileInputStream(file);
           
           //Creating workbook instance that refers to .xls file
           XSSFWorkbook wb=new XSSFWorkbook(inputStream);
           
           //Creating a Sheet object using the sheet Name
           XSSFSheet sheet=wb.getSheet("Login_Credentials");
           
        
           //Create a row object to retrieve row at index 1
           XSSFRow row2=sheet.getRow(2);
           
           //Create a cell object to retreive cell at index 5
           XSSFCell cell=row2.getCell(1);
       String username1= cell.getStringCellValue();
         
        	
       	 if(username1!= null) {
       		 return username1;
       		 }else {
       			 throw new RuntimeException("username not specified in test data"); 
       		 }
       	 }
             	
        }
        
    

