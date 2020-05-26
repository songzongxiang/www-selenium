package com.sh.stt.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 封装控制下拉滚动条
 */
public class ScrollBarUtil {
    /**
     * 控制滚动条拉到元素可见
     * @param driver 浏览器驱动
     * @param element 页面元素定位
     */
    public static void scrolltoPresence(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //移动到元素element对象与当前窗口对齐
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
