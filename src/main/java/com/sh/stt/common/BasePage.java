package com.sh.stt.common;

import com.sh.stt.util.Assertion;
import com.sh.stt.util.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 封装浏览器中界面上最基本操作
 */
public class BasePage {
    /**
     * 驱动
     */
    public WebDriver driver;

    /**
     * 动作
     */
    public Actions actions;

    /**
     * 脚本
     */
    public JavascriptExecutor js;

    /**
     * 显示等待
     */
    public WebDriverWait wait;

    /**
     * 当前窗口句柄
     */
    public String currentHandle;

    /**
     * 构造器
     * @param driver 驱动
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.js = ((JavascriptExecutor) driver);
        //显示等待时长
        long timeout = Long.valueOf(PropertiesReader.getKey("driver.timeouts.webDriverWait"));
        wait = new WebDriverWait(driver, timeout);
    }

    /*============================== 基本元素操作 ==============================*/

    /**
     * 跳转页面
     * @param url 网址
     */
    public void get(String url) {
        driver.get(url);
    }

    /**
     * 获取当前url
     * @return
     */
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * 封装 Element 方法
     * @param locator 类型元素定位
     * @return
     */
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    /**
     * 封装定位一组 Elements 的方法
     * @param locator 类型元素定位
     * @return
     */
    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    /**
     * 通过元素定位拿到 WebElement 元素对象
     * @param locator By 类型元素定位
     * @return 定位到的元素
     */
    public WebElement locateElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * 点击元素
     *
     * @param locator By 类型元素定位
     * @return 点击的元素
     */
    public WebElement clickButton(By locator) {
        WebElement buttonElement = locateElement(locator);
        buttonElement.click();
        return buttonElement;
    }

    /**
     * 输入框输入数据
     *
     * @param locator By 类型元素定位
     * @param content 输入的内容
     * @return 输入框元素
     */
    public WebElement sendInput(By locator, String content) {
        WebElement inputElement = locateElement(locator);
        inputElement.clear();
        inputElement.sendKeys(content);
        return inputElement;
    }

    /**
     * 移动到指定元素 鼠标悬停
     * @param element 元素定位
     */
    public void moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
    }

    /*============================== JS 操作 ==============================*/

    /**
     * 执行 JS 脚本
     * @param script JS 脚本
     * @param args 对象元素数组
     */
    public void executeScript(String script, Object... args) {
        js.executeScript(script, args);
    }

    /**
     * 页面滑动使得元素顶端和页面顶端对齐
     *
     * @param by 需要和页面顶端对齐的元素
     */
    public void scrollElementTopToTop(By by) {
        executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
    }

    /**
     * 页面滑动使得元素底端和页面底端对齐
     *
     * @param by 需要和页面底端对齐的元素
     */
    public void scrollElementBottomToBottom(By by) {
        executeScript("arguments[0].scrollIntoView(false);", driver.findElement(by));
    }

    /**
     * 页面滑动到最低端
     */
    public void scrollToBottom() {
        executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /*============================== 页面断言 ==============================*/

    /**
     * 判断当前页面标题是否是指定标题
     *
     * @param title 指定标题
     * @return 布尔值
     */
    public boolean ifTitleIs(String title) {
        return wait.until(ExpectedConditions.titleIs(title));
    }

    /**
     * 判断当前页面标题是否含有指定文本
     *
     * @param text 指定文本
     * @return 布尔值
     */
    public boolean ifTitleContains(String text) {
        return wait.until(ExpectedConditions.titleContains(text));
    }

    /**
     * 判断当前页面某个元素的文本值是否是指定文本
     *
     * @param locator 页面元素定位
     * @param text    指定文本
     * @return 布尔值
     */
    public boolean ifTextExists(By locator, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    /*============================== 切换句柄 ==============================*/

    /**
     * 切换 frame 结构
     * @param locator frame 定位
     * @return 驱动
     */
    public WebDriver switchFrame(By locator) {
        return driver.switchTo().frame(locateElement(locator));
    }

    /**
     * 多窗口切换句柄，依据传入的句柄号码
     *
     * @param num 号码从 1 开始
     * @return 驱动
     */
    public WebDriver switchHandle(int num) {
        // 当前窗口句柄
        String currentHandle = driver.getWindowHandle();
        // 所有窗口句柄
        Set<String> allHandlesSet = driver.getWindowHandles();
        List<String> allHandlesList = new ArrayList<>(allHandlesSet);
        // 切换句柄
        return driver.switchTo().window(allHandlesList.get(num - 1));
    }

    /**
     * 查找下一个句柄，建议两个窗口使用
     */
    public void switchNextHandle(){
        // 所有窗口句柄
        Set<String> allHandles = driver.getWindowHandles();
        // 寻找下一个句柄
        for (String handle:allHandles){
            if (handle.equals(currentHandle)){ //如果为 最先的窗口 权柄跳出
                continue;
            }
            driver.switchTo().window(handle); //如果不为最先的窗口权柄，将新窗口的操作权柄给driver
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());

            Assertion.verifyFalse(driver.getCurrentUrl().contains("404"), "URL含有'404'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
            Assertion.verifyFalse(driver.getCurrentUrl().contains("Error"), "URL含有'Error'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
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
            Assertion.verifyFalse(driver.getPageSource().contains("输入参数中包含异常信息"), "页面中含有'输入参数中包含异常信息'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());
            Assertion.verifyFalse(driver.getPageSource().contains("您现在访问的页面暂时无法 打开"), "页面中含有'您现在访问的页面暂时无法 打开'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());
            Assertion.verifyFalse(driver.getPageSource().contains("搜索关注“任我看助手”微信公众号，找找其他特惠产品吧"), "页面中含有'搜索关注“任我看助手”微信公众号，找找其他特惠产品吧'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());

            Assertion.verifyNotEquals(driver.getTitle(), "活动结束啦", "标题带有'活动结束啦'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
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
            driver.switchTo().window(currentHandle); //回到原始的浏览器窗口
        }
    }

    /**
     * 返回
     */
    public void back() {
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        Assertion.verifyFalse(driver.getCurrentUrl().contains("404"), "URL含有'404'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
        Assertion.verifyFalse(driver.getCurrentUrl().contains("Error"), "URL含有'Error'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
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
        Assertion.verifyFalse(driver.getPageSource().contains("输入参数中包含异常信息"), "页面中含有'输入参数中包含异常信息'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());
        Assertion.verifyFalse(driver.getPageSource().contains("您现在访问的页面暂时无法 打开"), "页面中含有'您现在访问的页面暂时无法 打开'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());
        Assertion.verifyFalse(driver.getPageSource().contains("搜索关注“任我看助手”微信公众号，找找其他特惠产品吧"), "页面中含有'搜索关注“任我看助手”微信公众号，找找其他特惠产品吧'" + "，当前URL:"+driver.getCurrentUrl() + ",当前标题："+driver.getTitle());

        Assertion.verifyNotEquals(driver.getTitle(), "活动结束啦", "标题带有'活动结束啦'" + "，当前URL:" + driver.getCurrentUrl() + "，当前标题：" + driver.getTitle());
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
