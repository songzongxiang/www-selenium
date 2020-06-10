package com.sh.stt.locator;

import org.openqa.selenium.By;

/**
 * 慈善基金会页面对象：元素定位
 */
public class CiShanLocator {

    /**
     * 页头导航区List集合定位
     */
    public static final By HEAD_NAV_LIST = By.xpath("//ul[@class='indexNav clearfix']/li/a");

    /**
     * 友情链接List集合定位
     */
    public static final By CS_LINK_LIST = By.xpath(".//*[@id='csLink']/div/a");

}
