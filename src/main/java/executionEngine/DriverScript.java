package executionEngine;

import config.ActionKeyWords;
import utils.ExcelUtils;

import java.lang.reflect.Method;

/**
 * @Author: Zhang Huijuan
 * @Date: 2021/9/30
 */
public class DriverScript {
    public static ActionKeyWords actionKeyWords;
    public static String keyWord;
    public static Method[] methods;

    public DriverScript() throws ClassNotFoundException {
        //可以使用ActionKeyWords keyWord = new ActionKeyWords()
        //初始化时创建一个ActionKeyWords对象
        Class aClass = Class.forName("config.ActionKeyWords");
        Method[] methods = aClass.getMethods();
    }

    public static void main(String[] args) {
//        String excelPath = "C:\\Users\\ydbj0140\\IdeaProjects\\SeleniumKeywordFramework\\src\\dataEngine\\dataEngine.xlsx";
        String excelPath = System.getProperty("user.dir") + "\\src\\main\\java\\dataEngine\\dataEngine.xlsx";

        // 加载读取excel文件
        ExcelUtils.setExcelFile(excelPath, "TestSteps");

        for (int iRow = 1; iRow <= 6; iRow++) {
            //从excel中读取关键字
            keyWord = ExcelUtils.getCellData(iRow, 3);


            /** 和excel文件中关键字进行对比
            if (sActionKeyword.equals("openBrowser")) {
                // 如果Excel文件中存在openBrowser的关键字就会调用openBrowser()方法，进行相关操作；下面其他关键字同理。
                ActionKeyWords.openBrowser();
            } else if (sActionKeyword.equals("openUrl")) {
                ActionKeyWords.openUrl();
            } else if (sActionKeyword.equals("clickLoginLink")) {
                ActionKeyWords.clickLoginLink();
            } else if (sActionKeyword.equals("inputUsername")) {
                ActionKeyWords.inputUsername();
            } else if (sActionKeyword.equals("inputPassword")) {
                ActionKeyWords.inputPassword();
            } else if (sActionKeyword.equals("clickLoginButton")) {
                ActionKeyWords.clickLoginButton();
            }*/

        }
    }
}
