package utils;

import config.Constants;
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

    public static void setExcelFile(String path) {
        try {
            excelFile = new FileInputStream(path);
            workbook = new XSSFWorkbook(excelFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCellData(int rowNum, int colNum, String sheetName) {
        sheet = workbook.getSheet(sheetName);
        cell = sheet.getRow(rowNum).getCell(colNum);
        if (cell.getCellType() == CellType.BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(Math.round(cell.getNumericCellValue()));
        }
        return cell.getStringCellValue();
    }

    //得到一共多少行数据
    public static int getRowCount(String sheetName) {
        sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() - 1;
        return rowCount;
    }

    //得到测试用例的行号
    public static int getRowContains(String sTestCaseName, int colNum, String SheetName) throws Exception {
        int i;
        sheet = workbook.getSheet(SheetName);
        int rowCount = ExcelUtils.getRowCount(SheetName);
        for (i = 0; i < rowCount; i++) {
            if (ExcelUtils.getCellData(i, colNum, SheetName).equalsIgnoreCase(sTestCaseName)) {
                break;
            }
        }
        return i;
    }

    //计算一个测试用例有多少个步骤
    public static int getTestStepsCount(String sheetName, String sTestCaseID, int iTestCaseStart) {
        for (int i = iTestCaseStart; i < ExcelUtils.getRowCount(sheetName); i++) {
            //判断TestCase ID一致
            if (sTestCaseID.equalsIgnoreCase(ExcelUtils.getCellData(i, Constants.Col_TestCaseID, sheetName))) {
                int number = i;
                return number;
            }
        }
        sheet = workbook.getSheet(sheetName);
        int number = getRowCount(sheetName);
        return number;
    }
}
