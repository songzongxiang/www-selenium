package com.sh.stt.page.aboutus;

import org.openqa.selenium.By;

/**
 * 关于中国移动--信息公开--公开目录页面元素
 */
public class GkmlPage {

    /**
     * 企业业务发展(包含：季度经营数据/中期报告/年报)
     */
    public static By enterBusDev = By.xpath(".//*[@id='main']/div[3]/div/div[1]/ul/li/span[1]/a");

    /**
     * 设备物资采购
     */
    //设备物资采购
    public static By equipmentMaterial = By.xpath(".//*[@id='menuul']/li[5]/span");
    //内容
    public static By equipmentMaterialContent = By.xpath(".//*[@id='menuul']/li[5]/ul/li/a/span");

}
