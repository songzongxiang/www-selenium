package com.sh.stt.page.aboutus;

import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.aboutus.GkmlLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于中国移动--信息公开--公开目录 页面对象
 */
public class GkmlPage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public GkmlPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有企业业务发展(包含：季度经营数据/中期报告/年报)的List集合
     */
    public List<String> enterBusDevList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(GkmlLocator.ENTER_BUS_DEV_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(GkmlLocator.ENTER_BUS_DEV_LIST);
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
    public List<String> equipmentMaterialList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(GkmlLocator.EQUIPMENT_MATERIAL_CONTENT, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(GkmlLocator.EQUIPMENT_MATERIAL_CONTENT);
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
