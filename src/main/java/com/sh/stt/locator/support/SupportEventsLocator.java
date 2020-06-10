package com.sh.stt.locator.support;

import org.openqa.selenium.By;

/**
 * 服务中心--客户服务--优惠专区页面对象：元素定位
 */
public class SupportEventsLocator {

    /**
     * 优惠专区--内容区
     */
    //内容区List集合定位
    public static final By SUPPORT_EVENTS_CONTENT_LIST = By.xpath(".//*[@id='lxlist']/div/div[2]/a");
    //下一页按钮集合定位
    public static final By SUPPORT_EVENTS_NEXT_BUTTON_LIST = By.xpath(".//*[@id='paging']/div[2]/a");
    //下一页按钮定位
    public static final By SUPPORT_EVENTS_NEXT_BUTTON = By.xpath(".//*[@id='paging']/div[2]/b[2]");

}
