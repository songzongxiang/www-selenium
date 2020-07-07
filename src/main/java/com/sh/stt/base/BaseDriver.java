package com.sh.stt.base;

import com.sh.stt.util.PropertiesReader;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 驱动基类
 */
@Slf4j
public class BaseDriver {

    /**
     * 浏览器驱动
     */
    private WebDriver driver;

    /**
     * 浏览器名称
     */
    private String browserName;

    /**
     * 终端选择 pc 或者 h5
     */
    private String terminal;

    /**
     * 设备选择
     */
    private String deviceName;

    /**
     * chrome 驱动路径
     */
    private String chromeDriverPath;

    /**
     * firefox 驱动路径
     */
    private String firefoxDriverPath;

    /**
     * 隐式等待时长（s）
     */
    private long implicitlyWait;

    /**
     * 页面加载等待时长（s）
     */
    private long pageLoadTimeout;

    /**
     * 脚本等待时长（s）
     */
    private long setScriptTimeout;

    /**
     * 本地线程存储用来存驱动
     */
    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    /**
     * 线程等待2000
     */
    public static final int THREE_THOUSANG = 2000;

    /**
     * 无参构造器
     * 初始化多种驱动路径参数
     * 初始化文件下载路径参数
     * 初始化多项等待时长参数
     */
    public BaseDriver() {
        /* 多种驱动文件路径配置参数 */
        chromeDriverPath = PropertiesReader.getKey("driver.chromeDriver");
        firefoxDriverPath = PropertiesReader.getKey("driver.firefoxDriver");
        implicitlyWait = Long.valueOf(PropertiesReader.getKey("driver.timeouts.implicitlyWait"));
        pageLoadTimeout = Long.valueOf(PropertiesReader.getKey("driver.timeouts.pageLoadTimeout"));
        setScriptTimeout = Long.valueOf(PropertiesReader.getKey("driver.timeouts.setScriptTimeout"));
    }

    /**
     * 启动本机中的浏览器
     *
     * @param browserName 浏览器名
     * @param terminal    pc 或者 h5
     * @param deviceName  设备名称
     * @throws Exception 抛出浏览器启动失败的异常
     */
    public void startBrowser(String browserName, String terminal, String deviceName) throws Exception {
        /* 驱动基本信息参数 */
        this.browserName = browserName.toLowerCase();
        /* 终端设备信息参数 */
        this.terminal = terminal.toLowerCase();
        this.deviceName = deviceName;
        /* 选择驱动，启动浏览器 */
        switch (browserName){
            // 1.谷歌
            case "chrome":
                try {
                    // 系统变量设置谷歌驱动
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                    HashMap<String, Object> hashMap = new HashMap<>();
                    // 驱动可选项配置
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setExperimentalOption("prefs", hashMap);
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    // 如果是 h5 需要另外设置
                    if (terminal.equals("h5")) {
                        Map<String, String> mobileEmulationMap = new HashMap<>();
                        mobileEmulationMap.put("deviceName", deviceName);
                        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulationMap);
                    }
                    // 启动 RemoteWebDriver
                    driver = new ChromeDriver(chromeOptions);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error(browserName + "浏览器启动失败！");
                }
                break;
            // 2.火狐
            case "firefox":
                try {
                    // 系统变量设置火狐驱动
                    System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
                    HashMap<String, Object> hashMap = new HashMap<>();
                    // 驱动可选项配置
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--no-sandbox");
                    firefoxOptions.addArguments("--disable-dev-shm-usage");
                    // 启动 RemoteWebDriver
                    driver = new FirefoxDriver(firefoxOptions);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error(browserName + "浏览器启动失败！");
                }
                break;
            // 都没匹配到则抛出异常
            default:
                throw new Exception("暂不支持的浏览器类型");
        }
        /* 驱动设置等待时长 */
        // 隐式等待
        driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
        // 页面加载等待
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        // 脚本等待
        driver.manage().timeouts().setScriptTimeout(setScriptTimeout, TimeUnit.SECONDS);
        /* 窗口最大化 */
        driver.manage().window().maximize();
        // 存进线程本地存储
        threadLocal.set(driver);
        log.info((terminal.equals("h5")) ? ("浏览器：" + browserName + " h5 成功启动！") : ("浏览器：" + browserName + " 成功启动！"));
        }

    /**
     * 取到浏览器驱动
     *
     * @return 浏览器驱动
     */
    public WebDriver getDriver(){
        return driver;
    }

    /**
     * 设置浏览器驱动
     *
     * @param driver 浏览器驱动
     */
    public void setDriver(WebDriver driver){
        this.driver = driver;
        // 存进线程本地存储
        threadLocal.set(driver);
    }

    /**
     * 驱动结束并关闭浏览器
     */
    public void closeBrowser() throws InterruptedException {
        // JS 显示弹出框表示测试结束
        ((JavascriptExecutor) driver).executeScript("alert('测试完成，浏览器在2s后关闭！')");
        Thread.sleep(THREE_THOUSANG);
        if (driver != null){
            driver.quit();
        }
        log.info(browserName + "浏览器已成功关闭！");
    }

}

