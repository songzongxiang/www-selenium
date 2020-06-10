package com.sh.stt.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 封装各个模块页面都可以使用的操作方法
 */
public class PageCommon extends BasePage {
    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public PageCommon(WebDriver driver) {
        super(driver);
    }

    /**
     * 判断元素是否存在
     * @param locator
     * @param timeoutSeconds
     * 最多等待的时间,单位 ： 秒
     * @return
     */
    public boolean isElementExist(By locator, int timeoutSeconds) {
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
    public boolean isNumber(String pageNum) {
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

}
