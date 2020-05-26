package com.sh.stt.page.support;

import org.openqa.selenium.By;

/**
 * 服务中心--终端应用--客户端下载页面元素
 */
public class SupportAppPage {

    /**
     * 终端应用--客户端下载
     */
    //客户端下载内容
    public static By supportAppContent = By.xpath(".//*[@id='r_3']/div[1]/ul/li/dl/dd/div/a");
    //下一页按钮集合
    public static By supportAppNextEles = By.xpath(".//*[@id='r_3']/div[2]/a");
    //下一页按钮
    public static By supportAppNextEle = By.xpath(".//*[@id='r_3']/div[2]/b[2]");

}
