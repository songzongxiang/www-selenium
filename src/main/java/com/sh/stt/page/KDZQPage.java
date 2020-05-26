package com.sh.stt.page;

import org.openqa.selenium.By;

/**
 * 宽带专区
 */
public class KDZQPage {

    /**
     * 优质产品
     */
    public static By broadbandProduct = By.xpath(".//*[@id='main']/div[6]/a");

    /**
     * 优质产品更多
     */
    public static By broadbandProductMore = By.id("yzcp_more");

    /**
     * 宽带产品列表
     */
    public static By broadbandProductList = By.xpath(".//*[@id='pd_listshow']/div/a/div[@class='cp_bm']/p");

    /**
     * 宽带服务
     */
    public static By broadbandService = By.xpath(".//*[@id='main']/div/div/div/ul/li/a");
}
