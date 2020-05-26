package com.sh.stt.page.support;

import org.openqa.selenium.By;

/**
 * 服务中心首页
 */
public class SupportIndex {

    /**
     * 主广告区
     */
    public static By supportBannerEle = By.xpath("//*[@id='banner_img']/div/a/img");

    /**
     * 快捷入口
     */
    public static By supportQuickEle = By.xpath(".//*[@id='main']/div[4]/ul/li/a");

    /**
     * 服务分类
     */
    public static By supportClassify = By.xpath(".//*[@id='main']/div[6]/div/div/span/img");
    //客户服务
    public static By supportCusService = By.xpath(".//*[@id='fwfl0T']/ul/li/a");
    //自助专区
    public static By supportSelfhelp = By.xpath(".//*[@id='fwfl1T']/ul/li/a");
    //业务资费
    public static By supportServiceFee = By.xpath(".//*[@id='fwfl2T']/ul/li/a");
    //终端应用
    public static By supportTerUti = By.xpath(".//*[@id='fwfl3T']/ul/li/a");

    /**
     * 特色业务说明
     */
    public static By supportTsywCon = By.xpath(".//*[@id='main']/div[8]/div[1]/div/ul/li/p/a");

    /**
     * 购物指南
     */
    public static By supportGouwuCon = By.xpath(".//*[@id='main']/div[7]/div[1]/div[1]/div/ul/li/p/a");

    /**
     * 商城帮助
     */
    public static By supportScHelp = By.xpath(".//*[@id='main']/div[7]/div[1]/div[2]/ul/li/p/a");

    /**
     * 问答专区
     */
    //搜索
    public static By supportSearchEle = By.className("sousuo");
    //搜答案
    public static By supportSeaAnswer = By.xpath(".//*[@id='wdzqform']/div/div/span");
    //问答
    public static By supportFAQ = By.xpath(".//*[@id='main']/div[7]/div[2]/div/ul/li/a");

}
