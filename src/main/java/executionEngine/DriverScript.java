package executionEngine;

import config.ActionKeyWords;
import config.Constants;
import utils.ExcelUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author: Zhang Huijuan
 * @Date: 2021/9/30
 */
public class DriverScript {
    public static ActionKeyWords actionKeyWords;
    public static String keyWord;
    public static String pageObjectWord;
    public static Method[] methods;
    public static Properties properties;

    public DriverScript() throws ClassNotFoundException {
        //可以使用ActionKeyWords keyWord = new ActionKeyWords()
        //初始化时创建一个ActionKeyWords对象
        Class aClass = Class.forName("config.ActionKeyWords");
        methods = aClass.getMethods();
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException, IOException {
        //程序进来后到main方法，所以必须先实例化一个DriverScript对象
        DriverScript script = new DriverScript();
//        String excelPath = System.getProperty("user.dir") + "\\src\\main\\java\\dataEngine\\dataEngine.xlsx";
        String excelPath = Constants.Path_TestData;
        String ORPath = Constants.Path_OR;

        //加载读取OR文件
        FileInputStream fis = new FileInputStream(ORPath);
        properties = new Properties(System.getProperties());
        properties.load(fis);
        // 加载读取excel文件
        ExcelUtils.setExcelFile(excelPath);
        for (int iRow = 1; iRow <= 6; iRow++) {
            //从excel中读取ActionWord列关键字， 4是此列的索引
            keyWord = ExcelUtils.getCellData(iRow, Constants.Col_ActionKeyword, );
            //从Excel中读取PageObject列关键字， 3是此列的索引
            pageObjectWord = ExcelUtils.getCellData(iRow, Constants.Col_TestPageObject,);
            executeActions();

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

    private static void executeActions() throws IllegalAccessException, InvocationTargetException {
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().equalsIgnoreCase(keyWord)) {
                methods[i].invoke(actionKeyWords, pageObjectWord);
                break;
            }
        }
    }
}
