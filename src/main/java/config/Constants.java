package config;

/**
 * @Author: Zhang Huijuan
 * @Date: 2021/10/8 22:27
 */
public class Constants {
    public static final String URL = "https://www.126.com";
    public static final String Path_TestData = ".//src//main//java//dataEngine//dataEngine.xlsx";
    public static final String File_TestData = "dataEngine.xlsx";
    public static final String Path_OR = ".//src//main//java//config//OR.txt";

    // dataEngine.xlsx中一些单元格的索引值
    public static final int Col_TestCaseID = 0;
    public static final int Col_TestScenarioID = 1 ;
    public static final int Col_TestPageObject = 3;
    public static final int Col_ActionKeyword = 4 ;
    public static final int Col_RunMode =2 ;

    // DataEngine.excel中sheet的名称
    public static final String Sheet_TestSteps = "TestSteps";
    //第二个sheet的名称
    public static final String Sheet_TestCases = "TestCases";

    // 测试登录用到的用户数据
    public static final String userName = "jamie_zhj";
    public static final String password = "wo8482125";
}
