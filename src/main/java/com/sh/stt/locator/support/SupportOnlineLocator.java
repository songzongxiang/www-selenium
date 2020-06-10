package com.sh.stt.locator.support;

import org.openqa.selenium.By;

/**
 * 服务中心--客户服务--网上营业厅页面对象：元素定位
 */
public class SupportOnlineLocator {

    /**
     * 客户服务--查询办理List集合定位
     */
    public static final By SUPPORT_QUERY_HANDLE_LIST = By.xpath(".//*[@id='idContent1']/dd/div/a");

    /**
     * 客户服务--网上营业厅List集合定位
     */
    public static final By SUPPORT_ONLINE_LIST = By.xpath("//*[@class='rightmain']/ul/li/dl/dd/p[not(@class='hp')]/a");

}
