package com.sh.stt.business.support;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.support.SupportIndex;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务中心首页业务层
 */
public class SupportIndexPro {

    /**
     * 获取所有主广告区的List集合
     */
    public static List<String> supportBannerList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportIndex.supportBannerEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportIndex.supportBannerEle);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("title"));
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有快捷入口的List集合
     */
    public static List<String> supportQuickList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportIndex.supportQuickEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportIndex.supportQuickEle);
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
     * 获取所有客户服务的List集合
     */
    public static List<String> supportCusServiceList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportIndex.supportCusService, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportIndex.supportCusService);
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
     * 获取所有自助专区的List集合
     */
    public static List<String> supportSelfhelpList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportIndex.supportSelfhelp, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportIndex.supportSelfhelp);
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
     * 获取所有业务资费的List集合
     */
    public static List<String> supportServiceFeeList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportIndex.supportServiceFee, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportIndex.supportServiceFee);
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
     * 获取所有终端应用的List集合
     */
    public static List<String> supportTerUtiList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportIndex.supportTerUti, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportIndex.supportTerUti);
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
     * 获取所有特色业务说明的List集合
     */
    public static List<String> supportTsywconList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportIndex.supportTsywCon, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportIndex.supportTsywCon);
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
     * 获取所有购物指南的List集合
     */
    public static List<String> supportGouwuconList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportIndex.supportGouwuCon, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportIndex.supportGouwuCon);
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
     * 获取所有商城帮助的List集合
     */
    public static List<String> supportScHelpList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportIndex.supportScHelp, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportIndex.supportScHelp);
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
     * 获取所有问答的List集合
     */
    public static List<String> supportFAQList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportIndex.supportFAQ, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportIndex.supportFAQ);
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
