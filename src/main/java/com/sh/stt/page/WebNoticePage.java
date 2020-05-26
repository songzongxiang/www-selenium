package com.sh.stt.page;

import org.openqa.selenium.By;

/**
 * 网站信息
 */
public class WebNoticePage {

    /**
     * 联系我们
     */
    public static By contactList = By.xpath(".//*[@id='main']/div[3]/div/div[1]/div/div/table/tbody/tr/td/div/a/strong/span");

    /**
     * 友情链接
     */
    public static By linksList = By.xpath(".//*[@id='main']/div[3]/div/div[1]/div/span/div/a");

    /**
     * 站点导航
     */
    public static By navigationList = By.xpath(".//*[@id='main']/div[2]/div/div[1]/ul/li/a");

}
