package com.sh.stt.business.aboutus;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.aboutus.GkmlPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于中国移动--信息公开--公开目录业务层
 */
public class GkmlPagePro {

    /**
     * 获取所有企业业务发展(包含：季度经营数据/中期报告/年报)的List集合
     */
    public static List<String> enterBusDevList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, GkmlPage.enterBusDev, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(GkmlPage.enterBusDev);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getText());
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有设备物资采购的List集合
     */
    public static List<String> equipmentMaterialList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, GkmlPage.equipmentMaterialContent, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(GkmlPage.equipmentMaterialContent);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getText());
                }
            }
        }
        return listString;
    }

}
