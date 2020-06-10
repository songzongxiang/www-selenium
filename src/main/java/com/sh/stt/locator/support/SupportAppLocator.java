package com.sh.stt.locator.support;

import org.openqa.selenium.By;

/**
 * 服务中心--终端应用--客户端下载页面对象：元素定位
 */
public class SupportAppLocator {

    /**
     * 终端应用--客户端下载
     */
    //客户端下载内容List集合定位
    public static final By SUPPORT_APP_CONTENT_LIST = By.xpath(".//*[@id='r_3']/div[1]/ul/li/dl/dd/div/a");
    //下一页按钮集合定位
    public static final By SUPPORT_APP_NEXT_BUTTON_LIST = By.xpath(".//*[@id='r_3']/div[2]/a");
    //下一页按钮定位
    public static final By SUPPORT_APP_NEXT_BUTTON = By.xpath(".//*[@id='r_3']/div[2]/b[2]");

}
