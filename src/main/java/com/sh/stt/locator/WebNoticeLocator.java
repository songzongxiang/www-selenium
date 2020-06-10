package com.sh.stt.locator;

import org.openqa.selenium.By;

/**
 * 网站信息页面对象：元素定位
 */
public class WebNoticeLocator {

    /**
     * 联系我们List集合定位
     */
    public static final By CONTACT_LIST = By.xpath(".//*[@id='main']/div[3]/div/div[1]/div/div/table/tbody/tr/td/div/a/strong/span");

    /**
     * 友情链接List集合定位
     */
    public static final By LINKS_LIST = By.xpath(".//*[@id='main']/div[3]/div/div[1]/div/span/div/a");

    /**
     * 站点导航List集合定位
     */
    public static final By NAVIGATION_LIST = By.xpath(".//*[@id='main']/div[2]/div/div[1]/ul/li/a");

}
