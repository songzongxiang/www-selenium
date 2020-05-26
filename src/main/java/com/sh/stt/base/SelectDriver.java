package com.sh.stt.base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class SelectDriver {
    public static WebDriver driverName(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            //实例化ChromeOptions
            ChromeOptions options = new ChromeOptions();
            //创建无Chrome无头参数
//            options.addArguments("-headless");
            //通过配置参数禁止data;的出现
//            options.addArguments("--user-data-dir="+System.getenv("USERPROFILE")+"/AppData/Local/Google/Chrome/User Data/Default");
//            //通过配置参数删除“您使用的是不受支持的命令行标记：--ignore-certificate-errors。稳定性和安全性会有所下降。”提示
//            options.addArguments("--start-maximized", "allow-running-insecure-content", "--test-type");
//            //使用该方法，浏览器不会弹‘Chrome正在受到自动软件的控制’提示。
//            options.addArguments("disable-infobars");
            //加载浏览器配置文件的路径
//            options.addArguments("--user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.setBinary("C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            return new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")){
            // 声明ProfilesIni对象
//            ProfilesIni pi = new ProfilesIni();
//            // 调用pi对象的getProfile方法获取名为“selenium”的用户配置文件
//            FirefoxProfile profile = pi.getProfile("selenium");
            System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
//            FirefoxOptions options = new FirefoxOptions();
//            options.setProfile(profile);
            return new FirefoxDriver();
        } else{
            System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();         // this line of code is to resolve protected mode issue
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            return new InternetExplorerDriver();
        }
    }
}
