package com.Facebook.utilLibrary;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.CellType;

public class GenericUtilityLibrary {

	public static String getCellValue(String pathOfFile, String sheetName, int rowNum, int cellNum) throws InvalidFormatException, IOException{
        FileInputStream fis = new FileInputStream("D://Selenium//workspace//Facebook_Project_POM//test-output//browserAndURL.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        CellType type = wb.getSheet("Sheet1").getRow(2).getCell(2).getCellType();
        String value = "";
        if(type==CellType.STRING){
            value = wb.getSheet("Sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();   
        }else if(type==CellType.NUMERIC){
            int numValue = (int) wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
            value = ""+numValue;
        }else if(type==CellType.BOOLEAN){
            boolean boolValue =  wb.getSheet("Sheet1").getRow(rowNum).getCell(cellNum).getBooleanCellValue();
            value = ""+boolValue;
        }
        return value;
    }
   
    public static void writeData(String pathOfFile, String sheetName, int rowNum, int cellNum, String value) throws InvalidFormatException, IOException{
        FileInputStream fis = new FileInputStream(pathOfFile);
        Workbook wb = WorkbookFactory.create(fis);
        wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(value);
        FileOutputStream fos = new FileOutputStream(pathOfFile);
        wb.write(fos);
    }
}
