package com.sh.stt.business;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.FiveGPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 5G专区业务层
 */
public class FiveGPagePro {

    /**
     * 获取所有快捷入口内容的List集合
     */
    public static List<String> quickContentList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, FiveGPage.quickEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(FiveGPage.quickEle);
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
     * 获取所有5G套餐内容的List集合
     */
    public static List<String> packageContentList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, FiveGPage.packageEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(FiveGPage.packageEle);
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
     * 获取所有5G终端内容的List集合
     */
    public static List<String> phoneContentList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, FiveGPage.phoneContentEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(FiveGPage.phoneContentEle);
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
     * 获取所有5G终端--轮播内容的List集合
     */
    public static List<String> phoneCarouselContentList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, FiveGPage.phoneCarouselContentEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(FiveGPage.phoneCarouselContentEle);
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
