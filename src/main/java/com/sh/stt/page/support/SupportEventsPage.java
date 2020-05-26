package com.sh.stt.page.support;

import org.openqa.selenium.By;

/**
 * 服务中心--客户服务--优惠专区页面元素
 */
public class SupportEventsPage {

    /**
     * 优惠专区--内容区
     */
    //内容区
    public static By supportEventsContent = By.xpath(".//*[@id='lxlist']/div/div[2]/a");
    //下一页按钮集合
    public static By supportEventsNextEles = By.xpath(".//*[@id='paging']/div[2]/a");
    //下一页按钮
    public static By supportEventsNextEle = By.xpath(".//*[@id='paging']/div[2]/b[2]");

}
