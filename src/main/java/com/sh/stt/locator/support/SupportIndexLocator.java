package com.sh.stt.locator.support;

import org.openqa.selenium.By;

/**
 * 服务中心首页页面对象：元素定位
 */
public class SupportIndexLocator {

    /**
     * 主广告区List集合定位
     */
    public static final By SUPPORT_BANNER_LIST = By.xpath("//*[@id='banner_img']/div/a/img");

    /**
     * 快捷入口List集合定位
     */
    public static final By SUPPORT_QUICK_LIST = By.xpath(".//*[@id='main']/div[4]/ul/li/a");

    /**
     * 服务分类List集合定位
     */
    public static final By SUPPORT_CLASSIFY_LIST = By.xpath(".//*[@id='main']/div[6]/div/div/span/img");
    //客户服务List集合定位
    public static final By SUPPORT_CUSTOMER_SERVICE_LIST = By.xpath(".//*[@id='fwfl0T']/ul/li/a");
    //自助专区List集合定位
    public static final By SUPPORT_SELF_HELP_LIST = By.xpath(".//*[@id='fwfl1T']/ul/li/a");
    //业务资费List集合定位
    public static final By SUPPORT_SERVICE_FEE_LIST = By.xpath(".//*[@id='fwfl2T']/ul/li/a");
    //终端应用List集合定位
    public static final By SUPPORT_TERMINAL_APP_LIST = By.xpath(".//*[@id='fwfl3T']/ul/li/a");

    /**
     * 特色业务说明List集合定位
     */
    public static final By SUPPORT_TSYW_CON_LIST = By.xpath(".//*[@id='main']/div[8]/div[1]/div/ul/li/p/a");

    /**
     * 购物指南List集合定位
     */
    public static final By SUPPORT_GOUWU_CON_LIST = By.xpath(".//*[@id='main']/div[7]/div[1]/div[1]/div/ul/li/p/a");

    /**
     * 商城帮助List集合定位
     */
    public static final By SUPPORT_SC_HELP_LIST = By.xpath(".//*[@id='main']/div[7]/div[1]/div[2]/ul/li/p/a");

    /**
     * 问答专区
     */
    //搜索框定位
    public static final By EleSUPPORT_SEARCH_INPUT = By.className("sousuo");
    //搜答案按钮定位
    public static final By SUPPORT_SEARCH_BUTTON = By.xpath(".//*[@id='wdzqform']/div/div/span");
    //问答List集合定位
    public static final By SUPPORT_FAQ_LIST = By.xpath(".//*[@id='main']/div[7]/div[2]/div/ul/li/a");

}
