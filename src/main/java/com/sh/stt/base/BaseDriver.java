package com.sh.stt.base;

import com.sh.stt.util.AssertListener;
import com.sh.stt.util.Assertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Listeners({AssertListener.class})
public class BaseDriver {
    public WebDriver driver;
    public String windowsHandle;

    @BeforeClass
    public void openBrowser(){
        driver = SelectDriver.driverName("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterClass
    public void close(){
        driver.quit();
    }

    /**
     * actionMoveElement actions 鼠标悬停
     */
    public void action(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * 判断元素是否存在
     * @param driver
     * @param locator
     * @param timeoutSeconds
     * 最多等待的时间,单位 ： 秒
     * @return
     */
    public static boolean isElementExist(WebDriver driver, By locator, int timeoutSeconds) {
        //隐式等待时间
        driver.manage().timeouts().implicitlyWait(timeoutSeconds, TimeUnit.SECONDS);
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断pageNum是不是数字
     * @param pageNum
     * @return
     */
    public static boolean isNumber(String pageNum) {
        // 把正则表达式编译成模式对象
        Pattern p = Pattern.compile("[0-9]*");
        // 通过模式对象得到匹配器对象，这个时候需要的是被匹配的字符串
        Matcher m = p.matcher(pageNum);
        // 调用匹配器对象的功能
        if (m.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 切换window窗口
     */
    public void getWindowsHandle(){
        Set<String> handles = driver.getWindowHandles();
        for (String handle:handles){
            if (handle.equals(windowsHandle)){ //如果为 最先的窗口 权柄跳出
                continue;
            }
            driver.switchTo().window(handle); //如果不为最先的窗口权柄，将新窗口的操作权柄给driver
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());

            Assertion.verifyFalse(driver.getCurrentUrl().contains("404"), "URL含有'404'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyFalse(driver.getTitle().contains("404"), "标题含有'404'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyFalse(driver.getTitle().contains("502"), "标题含有'502'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyFalse(driver.getTitle().contains("503"), "标题含有'503'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyFalse(driver.getTitle().contains("错误"), "标题含有'错误'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyFalse(driver.getPageSource().contains("商品已下架"), "页面中含有'商品已下架'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());
            Assertion.verifyFalse(driver.getPageSource().contains("503 Service Unavailable"), "页面中含有'503 Service Unavailable'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());
            Assertion.verifyFalse(driver.getPageSource().contains("系统繁忙，请稍后再试"), "页面中含有'系统繁忙，请稍后再试'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());
            Assertion.verifyFalse(driver.getPageSource().contains("很抱歉，您访问的页面穿越了"), "页面中含有'很抱歉，您访问的页面穿越了'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());
            Assertion.verifyFalse(driver.getPageSource().contains("程序员"), "页面中含有'程序员'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());
            Assertion.verifyFalse(driver.getPageSource().contains("Sorry, File not Found"), "页面中含有'Sorry, File not Found'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());

            Assertion.verifyNotEquals(driver.getTitle(), "403 Forbidden", "标题带有'403 Forbidden'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "地址或业务已下线", "标题带有'地址或业务已下线'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "ERROR", "标题带有'ERROR'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "sjsj.10086.cn", "标题带有'sjsj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "sxt.10086.cn", "标题带有'sxt.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "zwy.12582.10086.cn", "标题带有'zwy.12582.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "12582.10086.cn", "标题带有'12582.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "12580.10086.cn", "标题带有'12580.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "read.10086.cn", "标题带有'read.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());

            Assertion.verifyNotEquals(driver.getTitle(), "bj.10086.cn", "标题带有'bj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "ah.10086.cn", "标题带有'ah.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "cq.10086.cn", "标题带有'cq.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "fj.10086.cn", "标题带有'fj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "gd.10086.cn", "标题带有'gd.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "gx.10086.cn", "标题带有'gx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "gs.10086.cn", "标题带有'gs.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "gz.10086.cn", "标题带有'gz.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "he.10086.cn", "标题带有'he.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "ha.10086.cn", "标题带有'ha.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "hi.10086.cn", "标题带有'hi.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "hb.10086.cn", "标题带有'hb.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "hn.10086.cn", "标题带有'hn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "hl.10086.cn", "标题带有'hl.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "jl.10086.cn", "标题带有'jl.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "js.10086.cn", "标题带有'js.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "jx.10086.cn", "标题带有'jx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "ln.10086.cn", "标题带有'ln.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "nm.10086.cn", "标题带有'nm.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "nx.10086.cn", "标题带有'nx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "qh.10086.cn", "标题带有'qh.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "sh.10086.cn", "标题带有'sh.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "sc.10086.cn", "标题带有'sc.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "sd.10086.cn", "标题带有'sd.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "sx.10086.cn", "标题带有'sx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "sn.10086.cn", "标题带有'sn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "tj.10086.cn", "标题带有'tj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "xj.10086.cn", "标题带有'xj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "xz.10086.cn", "标题带有'xz.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "yn.10086.cn", "标题带有'yn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "zj.10086.cn", "标题带有'zj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.bj.10086.cn", "标题带有'service.bj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.ah.10086.cn", "标题带有'service.ah.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.cq.10086.cn", "标题带有'service.cq.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.fj.10086.cn", "标题带有'service.fj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.gd.10086.cn", "标题带有'service.gd.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.gx.10086.cn", "标题带有'service.gx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.gs.10086.cn", "标题带有'service.gs.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.gz.10086.cn", "标题带有'service.gz.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.he.10086.cn", "标题带有'service.he.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.ha.10086.cn", "标题带有'service.ha.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.hi.10086.cn", "标题带有'service.hi.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.hb.10086.cn", "标题带有'service.hb.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.hn.10086.cn", "标题带有'service.hn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.hl.10086.cn", "标题带有'service.hl.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.jl.10086.cn", "标题带有'service.jl.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.js.10086.cn", "标题带有'service.js.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.jx.10086.cn", "标题带有'service.jx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.ln.10086.cn", "标题带有'service.ln.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.nm.10086.cn", "标题带有'service.nm.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.nx.10086.cn", "标题带有'service.nx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.qh.10086.cn", "标题带有'service.qh.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.sh.10086.cn", "标题带有'service.sh.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.sc.10086.cn", "标题带有'service.sc.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.sd.10086.cn", "标题带有'service.sd.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.sx.10086.cn", "标题带有'service.sx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.sn.10086.cn", "标题带有'service.sn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.tj.10086.cn", "标题带有'service.tj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.xj.10086.cn", "标题带有'service.xj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.xz.10086.cn", "标题带有'service.xz.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.yn.10086.cn", "标题带有'service.yn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "service.zj.10086.cn", "标题带有'service.zj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.bj.10086.cn", "标题带有'www.bj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.ah.10086.cn", "标题带有'www.ah.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.cq.10086.cn", "标题带有'www.cq.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.fj.10086.cn", "标题带有'www.fj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.gd.10086.cn", "标题带有'www.gd.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.gx.10086.cn", "标题带有'www.gx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.gs.10086.cn", "标题带有'www.gs.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.gz.10086.cn", "标题带有'www.gz.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.he.10086.cn", "标题带有'www.he.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.ha.10086.cn", "标题带有'www.ha.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.hi.10086.cn", "标题带有'www.hi.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.hb.10086.cn", "标题带有'www.hb.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.hn.10086.cn", "标题带有'www.hn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.hl.10086.cn", "标题带有'www.hl.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.jl.10086.cn", "标题带有'www.jl.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.js.10086.cn", "标题带有'www.js.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.jx.10086.cn", "标题带有'www.jx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.ln.10086.cn", "标题带有'www.ln.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.nm.10086.cn", "标题带有'www.nm.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.nx.10086.cn", "标题带有'www.nx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.qh.10086.cn", "标题带有'www.qh.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.sh.10086.cn", "标题带有'www.sh.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.sc.10086.cn", "标题带有'www.sc.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.sd.10086.cn", "标题带有'www.sd.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.sx.10086.cn", "标题带有'www.sx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.sn.10086.cn", "标题带有'www.sn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.tj.10086.cn", "标题带有'www.tj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.xj.10086.cn", "标题带有'www.xj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.xz.10086.cn", "标题带有'www.xz.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.yn.10086.cn", "标题带有'www.yn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
            Assertion.verifyNotEquals(driver.getTitle(), "www.zj.10086.cn", "标题带有'www.zj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());

            driver.close(); //关闭新弹出的浏览器窗口
            driver.switchTo().window(windowsHandle); //回到原始的浏览器窗口
        }
    }

    /**
     * 返回
     */
    public void back() {
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Assertion.verifyFalse(driver.getCurrentUrl().contains("404"), "URL含有'404'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyFalse(driver.getTitle().contains("404"), "标题含有'404'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyFalse(driver.getTitle().contains("502"), "标题含有'502'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyFalse(driver.getTitle().contains("503"), "标题含有'503'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyFalse(driver.getTitle().contains("错误"), "标题含有'错误'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyFalse(driver.getPageSource().contains("商品已下架"), "页面中含有'商品已下架'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());
        Assertion.verifyFalse(driver.getPageSource().contains("503 Service Unavailable"), "页面中含有'503 Service Unavailable'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());
        Assertion.verifyFalse(driver.getPageSource().contains("系统繁忙，请稍后再试"), "页面中含有'系统繁忙，请稍后再试'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());
        Assertion.verifyFalse(driver.getPageSource().contains("很抱歉，您访问的页面穿越了"), "页面中含有'很抱歉，您访问的页面穿越了'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());
        Assertion.verifyFalse(driver.getPageSource().contains("程序员"), "页面中含有'程序员'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());
        Assertion.verifyFalse(driver.getPageSource().contains("Sorry, File not Found"), "页面中含有'Sorry, File not Found'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());

        Assertion.verifyNotEquals(driver.getTitle(), "403 Forbidden", "标题带有'403 Forbidden'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "地址或业务已下线", "标题带有'地址或业务已下线'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "ERROR", "标题带有'ERROR'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "sjsj.10086.cn", "标题带有'sjsj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "sxt.10086.cn", "标题带有'sxt.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "zwy.12582.10086.cn", "标题带有'zwy.12582.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "12582.10086.cn", "标题带有'12582.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "12580.10086.cn", "标题带有'12580.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "read.10086.cn", "标题带有'read.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());

        Assertion.verifyNotEquals(driver.getTitle(), "bj.10086.cn", "标题带有'bj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "ah.10086.cn", "标题带有'ah.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "cq.10086.cn", "标题带有'cq.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "fj.10086.cn", "标题带有'fj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "gd.10086.cn", "标题带有'gd.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "gx.10086.cn", "标题带有'gx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "gs.10086.cn", "标题带有'gs.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "gz.10086.cn", "标题带有'gz.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "he.10086.cn", "标题带有'he.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "ha.10086.cn", "标题带有'ha.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "hi.10086.cn", "标题带有'hi.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "hb.10086.cn", "标题带有'hb.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "hn.10086.cn", "标题带有'hn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "hl.10086.cn", "标题带有'hl.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "jl.10086.cn", "标题带有'jl.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "js.10086.cn", "标题带有'js.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "jx.10086.cn", "标题带有'jx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "ln.10086.cn", "标题带有'ln.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "nm.10086.cn", "标题带有'nm.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "nx.10086.cn", "标题带有'nx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "qh.10086.cn", "标题带有'qh.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "sh.10086.cn", "标题带有'sh.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "sc.10086.cn", "标题带有'sc.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "sd.10086.cn", "标题带有'sd.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "sx.10086.cn", "标题带有'sx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "sn.10086.cn", "标题带有'sn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "tj.10086.cn", "标题带有'tj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "xj.10086.cn", "标题带有'xj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "xz.10086.cn", "标题带有'xz.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "yn.10086.cn", "标题带有'yn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "zj.10086.cn", "标题带有'zj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.bj.10086.cn", "标题带有'service.bj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.ah.10086.cn", "标题带有'service.ah.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.cq.10086.cn", "标题带有'service.cq.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.fj.10086.cn", "标题带有'service.fj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.gd.10086.cn", "标题带有'service.gd.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.gx.10086.cn", "标题带有'service.gx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.gs.10086.cn", "标题带有'service.gs.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.gz.10086.cn", "标题带有'service.gz.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.he.10086.cn", "标题带有'service.he.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.ha.10086.cn", "标题带有'service.ha.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.hi.10086.cn", "标题带有'service.hi.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.hb.10086.cn", "标题带有'service.hb.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.hn.10086.cn", "标题带有'service.hn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.hl.10086.cn", "标题带有'service.hl.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.jl.10086.cn", "标题带有'service.jl.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.js.10086.cn", "标题带有'service.js.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.jx.10086.cn", "标题带有'service.jx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.ln.10086.cn", "标题带有'service.ln.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.nm.10086.cn", "标题带有'service.nm.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.nx.10086.cn", "标题带有'service.nx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.qh.10086.cn", "标题带有'service.qh.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.sh.10086.cn", "标题带有'service.sh.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.sc.10086.cn", "标题带有'service.sc.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.sd.10086.cn", "标题带有'service.sd.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.sx.10086.cn", "标题带有'service.sx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.sn.10086.cn", "标题带有'service.sn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.tj.10086.cn", "标题带有'service.tj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.xj.10086.cn", "标题带有'service.xj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.xz.10086.cn", "标题带有'service.xz.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.yn.10086.cn", "标题带有'service.yn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "service.zj.10086.cn", "标题带有'service.zj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.bj.10086.cn", "标题带有'www.bj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.ah.10086.cn", "标题带有'www.ah.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.cq.10086.cn", "标题带有'www.cq.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.fj.10086.cn", "标题带有'www.fj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.gd.10086.cn", "标题带有'www.gd.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.gx.10086.cn", "标题带有'www.gx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.gs.10086.cn", "标题带有'www.gs.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.gz.10086.cn", "标题带有'www.gz.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.he.10086.cn", "标题带有'www.he.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.ha.10086.cn", "标题带有'www.ha.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.hi.10086.cn", "标题带有'www.hi.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.hb.10086.cn", "标题带有'www.hb.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.hn.10086.cn", "标题带有'www.hn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.hl.10086.cn", "标题带有'www.hl.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.jl.10086.cn", "标题带有'www.jl.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.js.10086.cn", "标题带有'www.js.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.jx.10086.cn", "标题带有'www.jx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.ln.10086.cn", "标题带有'www.ln.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.nm.10086.cn", "标题带有'www.nm.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.nx.10086.cn", "标题带有'www.nx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.qh.10086.cn", "标题带有'www.qh.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.sh.10086.cn", "标题带有'www.sh.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.sc.10086.cn", "标题带有'www.sc.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.sd.10086.cn", "标题带有'www.sd.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.sx.10086.cn", "标题带有'www.sx.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.sn.10086.cn", "标题带有'www.sn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.tj.10086.cn", "标题带有'www.tj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.xj.10086.cn", "标题带有'www.xj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.xz.10086.cn", "标题带有'www.xz.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.yn.10086.cn", "标题带有'www.yn.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());
        Assertion.verifyNotEquals(driver.getTitle(), "www.zj.10086.cn", "标题带有'www.zj.10086.cn'并且页面无法显示" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题："+driver.getTitle());

        driver.navigate().back();
    }

}
