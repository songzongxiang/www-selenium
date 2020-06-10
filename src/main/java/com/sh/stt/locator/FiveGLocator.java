package com.sh.stt.locator;

import org.openqa.selenium.By;

/**
 * 5G专区页面对象：元素定位
 */
public class FiveGLocator {

    /**
     * 快捷入口List集合定位
     */
    public static final By FIVEG_QUICK_LIST = By.xpath("//div[@class='entry']/a");

    /**
     * 5G套餐List集合定位
     */
    public static final By FIVEG_PACKAGE_LIST = By.xpath(".//*[@id='5G_TC']/div/div/div/ul/li/dl/a/dd/span");

    /**
     * 5G终端
     */
    //终端内容List集合定位
    public static final By FIVEG_PHONE_CONTENT_LIST = By.xpath(".//*[@id='5G_HOME_Client']/div[1]/dl/a");
    //轮播内容List集合定位
    public static final By FIVEG_CAROUSEL_CONTENT_LIST = By.xpath(".//*[@id='5G_HOME_Client']/div[2]/div/div[2]/div/ul/li/dl/a");

}
