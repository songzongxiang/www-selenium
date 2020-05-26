package com.sh.stt.page.support;

import org.openqa.selenium.By;

/**
 * 服务中心--客户服务--网上营业厅页面元素
 */
public class SupportOnlinePage {

    /**
     * 客户服务--查询办理
     */
    public static By supportQueryHandle = By.xpath(".//*[@id='idContent1']/dd/div/a");

    /**
     * 客户服务--网上营业厅
     */
    public static By supportOnlineEle = By.xpath("//*[@class='rightmain']/ul/li/dl/dd/p[not(@class='hp')]/a");

}
