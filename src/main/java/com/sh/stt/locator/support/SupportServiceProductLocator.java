package com.sh.stt.locator.support;

import org.openqa.selenium.By;

/**
 * 服务中心--业务资费--产品页面对象：元素定位
 */
public class SupportServiceProductLocator {

    /**
     * 业务资费--产品List集合定位
     */
    public static final By SUPPORT_SERVICE_PRODUCT_LIST = By.xpath("//*[@class='chanpin']/div[not(@id='cpthree') and not(@id='cpfive') and not(@id='cpsix')]/ul/li/a");

    /**
     * 业务资费详情--业务专区集合定位
     */
    public static final By SUPPORT_SERVICE_PRODUCT_DETAILS = By.xpath("//*[@id='main']/div[3]/div/div[2]/a[not(contains(text(), '了解更多'))]");

}
