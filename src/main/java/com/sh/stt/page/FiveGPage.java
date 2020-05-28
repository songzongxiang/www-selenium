package com.sh.stt.page;

import org.openqa.selenium.By;

/**
 * 5G页面元素
 */
public class FiveGPage {

    /**
     * 快捷入口
     */
    public static By quickEle = By.xpath("//div[@class='entry']/a");

    /**
     * 5G套餐
     */
    public static By packageEle = By.xpath(".//*[@id='5G_TC']/div/div/div/ul/li/dl/a/dd/span");

    /**
     * 5G终端
     */
    //终端内容
    public static By phoneContentEle = By.xpath(".//*[@id='5G_HOME_Client']/div[1]/dl/a");
    //轮播内容
    public static By phoneCarouselContentEle = By.xpath(".//*[@id='5G_HOME_Client']/div[2]/div/div[2]/div/ul/li/dl/a");

}
