package com.sh.stt.locator;

import org.openqa.selenium.By;

/**
 * 宽带专区页面对象：元素定位
 */
public class KDZQLocator {

    /**
     * 优质产品List集合定位
     */
    public static final By BROADBAND_PRODUCT = By.xpath(".//*[@id='main']/div[6]/a");

    /**
     * 优质产品更多按钮定位
     */
    public static final By BROADBAND_PRODUCT_MORE_BUTTON = By.id("yzcp_more");

    /**
     * 宽带产品列表List集合定位
     */
    public static final By BROADBAND_PRODUCT_LIST = By.xpath(".//*[@id='pd_listshow']/div/a/div[@class='cp_bm']/p");

    /**
     * 宽带服务List集合定位
     */
    public static final By BROADBAND_SERVICE = By.xpath(".//*[@id='main']/div/div/div/ul/li/a");
}
