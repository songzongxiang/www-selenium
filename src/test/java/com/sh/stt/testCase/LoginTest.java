package com.sh.stt.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

//    @BeforeMethod
    @Test
    public void openChrome() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
//        //实例化chromedriver
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
//        driver = new FirefoxDriver();
//        System.setProperty("webdriver.ie.driver","./drivers/IEDriverServer.exe");
//        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();         // this line of code is to resolve protected mode issue
//        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//        driver = new InternetExplorerDriver();

        driver.get("http://www.baidu.com");
        driver.findElement(By.linkText("新闻")).click();
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void getTest() throws InterruptedException {
        //实例化Dimension 设置窗口大小
        Dimension dimension = new Dimension(300,300);
        driver.manage().window().setSize(dimension);
        //浏览器最大化
        driver.manage().window().maximize();
        //打开百度首页
        driver.get("https://www.baidu.com");
//        driver.navigate().to("https://www.baidu.com");
        //等待3s
        Thread.sleep(3000);
        driver.navigate().refresh();
        //后退
//        driver.navigate().back();
//        Thread.sleep(3000);
//        //前进
//        driver.navigate().forward();
        //关闭浏览器
        Thread.sleep(3000);
        driver.quit();
    }

//    @Test
//    public void testAssert() {
//        AssertionTest.setFlag(true);
//        System.out.println("Test1");
//        AssertionTest.verifyEquals(1,2,"不相同");
//        System.out.println("Test2");
//        Assert.assertTrue(AssertionTest.currentFlag());
//    }




}
