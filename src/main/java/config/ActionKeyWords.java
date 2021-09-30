package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Zhang Huijuan
 * @Date: 2021/9/30
 */
public class ActionKeyWords {
    public static WebDriver webDriver;

    public static void openBrowser(){
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\lib\\geckodriver.exe");
//        System.out.println(System.getProperty("webDriver.firefox.driver"));
        webDriver = new FirefoxDriver();
    }
    public static void openUrl() {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://www.126.com/");
    }
    public static void clickLoginLink() {
        WebElement element = webDriver.findElement(By.xpath("//iframe[contains(@id,'x-URS-iframe')]"));
        element.click();
        webDriver.switchTo().frame(element);

    }
    public static void inputUsername() {
        webDriver.findElement(By.xpath("//input[contains(@data-placeholder,'邮箱帐号或手机号')]")).sendKeys("jamie_zhj");
    }
    public static void inputPassword() {
        webDriver.findElement(By.xpath("//input[@name='password']")).sendKeys("wo8482125");
    }
    public static void clickLoginButton() {
        webDriver.findElement(By.id("dologin")).click();
    }

}