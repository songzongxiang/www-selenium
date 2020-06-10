package com.sh.stt.locator;

import org.openqa.selenium.By;

/**
 * 宽带提速降费页面对象：元素定位
 */
public class KDTSJFLocator {

    /**
     * 宽带新装List集合定位
     */
    public static final By BROADBAND_NEW_CLOTHES_LIST = By.xpath(".//*[@id='kdxz_pd']/a/div[@class='cp_bm']/p");

    /**
     * 宽带升级List集合定位
     */
    public static final By BROADBAND_UPGRADE_LIST = By.xpath(".//*[@id='kdsj_pd']/a/div[@class='cp_bm']/p");

}
