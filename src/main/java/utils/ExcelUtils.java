package utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: Zhang Huijuan
 * @Date: 2021/9/30
 * 读取excel文件
 */
public class ExcelUtils {
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFCell cell;
    public static FileInputStream excelFile;

    public static void setExcelFile(String path, String sheetName) {
        try {
            excelFile = new FileInputStream(path);
            workbook = new XSSFWorkbook(excelFile);
            sheet = workbook.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getCellData(int rowNum, int colNum) {
        cell = sheet.getRow(rowNum).getCell(colNum);
        if (cell.getCellType() == CellType.BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        }else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(Math.round(cell.getNumericCellValue()));
        }
        return cell.getStringCellValue();
    }
}
