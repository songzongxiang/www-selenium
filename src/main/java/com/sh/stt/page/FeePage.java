package com.sh.stt.page;

import org.openqa.selenium.By;

/**
 * 资费专区页面元素
 */
public class FeePage {

    /**
     * 加载更多
     */
    public static By feeMoreEle = By.xpath(".//*[@id='more_pcxb']/a");

    /**
     * 基础套餐/可选包内容
     */
    public static By feeContentEle = By.xpath(".//*[@id='main']/div/div/div/div[2]/a");

}
