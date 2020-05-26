package com.sh.stt.business.support;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.support.SupportOnlinePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务中心--客户服务--网上营业厅业务层
 */
public class SupportOnlinePagePro {

    /**
     * 获取所有查询办理的List集合
     */
    public static List<String> supportQueryHandleList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportOnlinePage.supportQueryHandle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportOnlinePage.supportQueryHandle);
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
     * 获取所有网上营业厅的List集合
     */
    public static List<String> supportOnlineList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportOnlinePage.supportOnlineEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportOnlinePage.supportOnlineEle);
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
