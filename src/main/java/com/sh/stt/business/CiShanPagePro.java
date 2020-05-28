package com.sh.stt.business;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.CiShanPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 慈善基金会业务层
 */
public class CiShanPagePro {

    /**
     * 获取所有页头导航区内容的List集合
     */
    public static List<String> headNavList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, CiShanPage.headNavEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(CiShanPage.headNavEle);
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
     * 获取所有友情链接内容的List集合
     */
    public static List<String> csLinkList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, CiShanPage.csLinkEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(CiShanPage.csLinkEle);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("href"));
                }
            }
        }
        return listString;
    }

}
