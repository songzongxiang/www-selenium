package com.sh.stt.locator;

import org.openqa.selenium.By;

/**
 * 资费专区页面对象：元素定位
 */
public class FeeLocator {

    /**
     * 加载更多按钮定位
     */
    public static final By FEE_MORE_BUTTON = By.linkText("加载更多");

    /**
     * 基础套餐/可选包内容List集合定位
     */
    public static final By FEE_CONTENT_LIST = By.xpath(".//*[@id='main']/div/div/div/div[2]/a");

}
