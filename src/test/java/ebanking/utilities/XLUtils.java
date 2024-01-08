package ebanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
    // FileInputStream and FileOutputStream instances for reading and writing Excel files
    public static FileInputStream fi;
    public static FileOutputStream fo;

    // XSSFWorkbook instance to represent the Excel workbook
    public static XSSFWorkbook wb;

    // XSSFSheet instance to represent an Excel sheet
    public static XSSFSheet ws;

    // XSSFRow and XSSFCell instances to represent a row and a cell in Excel
    public static XSSFRow row;
    public static XSSFCell cell;

    // Method to get the row count in an Excel sheet
    public static int getRowCount(String xlfile, String xlsheet) throws IOException {
        try (FileInputStream fi = new FileInputStream(xlfile); XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            XSSFSheet ws = wb.getSheet(xlsheet);
            return ws.getLastRowNum();
        }
    }

    // Method to get the cell count in a specific row of an Excel sheet
    public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
        try (FileInputStream fi = new FileInputStream(xlfile); XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            XSSFSheet ws = wb.getSheet(xlsheet);
            XSSFRow row = ws.getRow(rownum);
            return row.getLastCellNum();
        }
    }

    // Method to get the data from a specific cell in an Excel sheet
    public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
        try (FileInputStream fi = new FileInputStream(xlfile); XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            XSSFSheet ws = wb.getSheet(xlsheet);
            XSSFRow row = ws.getRow(rownum);
            XSSFCell cell = row.getCell(colnum);
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        }
    }

    // Method to set data in a specific cell in an Excel sheet
    public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException {
        try (FileInputStream fi = new FileInputStream(xlfile); XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            XSSFSheet ws = wb.getSheet(xlsheet);
            XSSFRow row = ws.getRow(rownum);
            XSSFCell cell = row.createCell(colnum);
            cell.setCellValue(data);
            try (FileOutputStream fo = new FileOutputStream(xlfile)) {
                wb.write(fo);
            }
        }
    }
}
