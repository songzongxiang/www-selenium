package com.sh.stt.business;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.KDTSJFPage;
import com.sh.stt.page.KDZQPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KDZQPagePro {

    /**
     * 获取所有宽带专区--优质产品的List集合
     */
    public static List<String> broadbandProduct(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, KDZQPage.broadbandProduct, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(KDZQPage.broadbandProduct);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        return listString;
    }


    /**-
     * 获取所有宽带专区--宽带服务的List集合
     */
    public static List<String> broadbandService(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, KDZQPage.broadbandService, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(KDZQPage.broadbandService);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有宽带专区--宽带产品列表的List集合
     */
    public static List<String> broadbandProductList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, KDZQPage.broadbandProductList, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(KDZQPage.broadbandProductList);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("title"));
                }
            }
        }
        return listString;
    }
}
