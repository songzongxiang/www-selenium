package com.sh.stt.base;

import com.sh.stt.listener.AssertListener;
import com.sh.stt.listener.LogListener;
import com.sh.stt.util.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

/**
 * 测试基类
 */
@Listeners({AssertListener.class, LogListener.class})
public class BaseTest {

    /**
     * 配置文件
     */
    public static Properties properties;

    /**
     * 驱动基类
     */
    private BaseDriver browserDriver;

    /**
     * 驱动
     */
    public WebDriver driver;

    /**
     * 执行一个测试套之前执行
     * 进行测试配置文件的读取工作
     *
     * @param propertiesPath 测试配置文件项目路径
     * @throws IOException IOException
     */
    @BeforeSuite(alwaysRun = true)
    @Parameters({"propertiesPath"})
    public void beforeSuite(@Optional("src/test/resources/config/config.properties") String propertiesPath) throws IOException {
        // 配置文件读取，存进静态变量 properties
        properties = PropertiesReader.readProperties(propertiesPath);
    }

    /**
     * 执行一个测试用例中的类方法之前执行
     *
     * @param browserName 浏览器名
     * @param terminal 终端选择 pc 或者 h5
     * @param deviceName 设备选择
     * @throws Exception 抛出浏览器没有启动成功异常
     */
    @BeforeClass(alwaysRun = true)
    @Parameters({"browserName", "terminal", "deviceName"})
    public void beforeClass(@Optional("chrome") String browserName, @Optional("pc") String terminal, @Optional("desktop") String deviceName) throws Exception {
        /* 驱动配置 */
        browserDriver = new BaseDriver();
        browserDriver.startBrowser(browserName, terminal, deviceName);
        driver = browserDriver.getDriver();
    }

    /**
     * 执行一个测试用例中的类方法之后执行
     */
    @AfterClass(alwaysRun = true)
    public void afterClass() throws InterruptedException {
        // 驱动退出关闭浏览器
        browserDriver.closeBrowser();
    }

}
