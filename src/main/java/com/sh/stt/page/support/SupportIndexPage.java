package com.sh.stt.page.support;

import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.support.SupportIndexLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务中心首页 页面对象
 */
public class SupportIndexPage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public SupportIndexPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有主广告区的List集合
     */
    public List<String> supportBannerList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportIndexLocator.SUPPORT_BANNER_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportIndexLocator.SUPPORT_BANNER_LIST);
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
    public List<String> supportQuickList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportIndexLocator.SUPPORT_QUICK_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportIndexLocator.SUPPORT_QUICK_LIST);
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
    public List<String> supportCusServiceList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportIndexLocator.SUPPORT_CUSTOMER_SERVICE_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportIndexLocator.SUPPORT_CUSTOMER_SERVICE_LIST);
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
    public List<String> supportSelfhelpList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportIndexLocator.SUPPORT_SELF_HELP_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportIndexLocator.SUPPORT_SELF_HELP_LIST);
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
    public List<String> supportServiceFeeList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportIndexLocator.SUPPORT_SERVICE_FEE_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportIndexLocator.SUPPORT_SERVICE_FEE_LIST);
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
    public List<String> supportTerUtiList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportIndexLocator.SUPPORT_TERMINAL_APP_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportIndexLocator.SUPPORT_TERMINAL_APP_LIST);
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
    public List<String> supportTsywconList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportIndexLocator.SUPPORT_TSYW_CON_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportIndexLocator.SUPPORT_TSYW_CON_LIST);
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
    public List<String> supportGouwuconList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportIndexLocator.SUPPORT_GOUWU_CON_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportIndexLocator.SUPPORT_GOUWU_CON_LIST);
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
    public List<String> supportScHelpList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportIndexLocator.SUPPORT_SC_HELP_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportIndexLocator.SUPPORT_SC_HELP_LIST);
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
    public List<String> supportFAQList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportIndexLocator.SUPPORT_FAQ_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportIndexLocator.SUPPORT_FAQ_LIST);
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
