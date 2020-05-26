package com.sh.stt.business;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.KDZQPage;
import com.sh.stt.page.WebNoticePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 网站信息业务层
 */
public class WebNoticePagePro {

    /**
     * 获取所有联系我们的List集合
     */
    public static List<String> contactList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, WebNoticePage.contactList, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(WebNoticePage.contactList);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getText());
                    System.out.println(element.getText());
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有友情链接的List集合
     */
    public static List<String> linksList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, WebNoticePage.linksList, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(WebNoticePage.linksList);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("href"));
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有站点导航的List集合
     */
    public static List<String> navigationList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, WebNoticePage.navigationList, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(WebNoticePage.navigationList);
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
