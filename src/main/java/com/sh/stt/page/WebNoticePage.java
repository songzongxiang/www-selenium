package com.sh.stt.page;

import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.WebNoticeLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 网站信息 页面对象
 */
public class WebNoticePage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public WebNoticePage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有联系我们的List集合
     */
    public List<String> contactList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(WebNoticeLocator.CONTACT_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(WebNoticeLocator.CONTACT_LIST);
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
     * 获取所有友情链接的List集合
     */
    public List<String> linksList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(WebNoticeLocator.LINKS_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(WebNoticeLocator.LINKS_LIST);
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
    public List<String> navigationList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(WebNoticeLocator.NAVIGATION_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(WebNoticeLocator.NAVIGATION_LIST);
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
