package com.sh.stt.locator.aboutus;

import org.openqa.selenium.By;

/**
 * 关于中国移动--信息公开--公开目录页面对象：元素定位
 */
public class GkmlLocator {

    /**
     * 企业业务发展(包含：季度经营数据/中期报告/年报)List集合定位
     */
    public static final By ENTER_BUS_DEV_LIST = By.xpath(".//*[@id='main']/div[3]/div/div[1]/ul/li/span[1]/a");

    /**
     * 设备物资采购
     */
    //设备物资采购定位
    public static final By EQUIPMENT_MATERIAL_BUTTON = By.xpath(".//*[@id='menuul']/li[5]/span");
    //内容List集合定位
    public static final By EQUIPMENT_MATERIAL_CONTENT = By.xpath(".//*[@id='menuul']/li[5]/ul/li/a/span");

}
