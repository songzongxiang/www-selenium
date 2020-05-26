package com.sh.stt.page.support;

import org.openqa.selenium.By;

/**
 * 服务中心--业务资费--产品页面元素
 */
public class SupportServiceProductPage {

    /**
     * 业务资费--产品
     */
    public static By supportServiceProduct = By.xpath("//*[@class='chanpin']/div[not(@id='cpthree') and not(@id='cpfive') and not(@id='cpsix')]/ul/li/a");

    /**
     * 业务资费详情--业务专区
     */
    public static By supportServiceProductDel = By.xpath("//*[@id='main']/div[3]/div/div[2]/a[not(contains(text(), '了解更多'))]");

}
