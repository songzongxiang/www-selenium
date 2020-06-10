package com.sh.stt.page.support;

import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.support.SupportOnlineLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务中心--客户服务--网上营业厅 页面对象
 */
public class SupportOnlinePage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public SupportOnlinePage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有查询办理的List集合
     */
    public List<String> supportQueryHandleList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportOnlineLocator.SUPPORT_QUERY_HANDLE_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportOnlineLocator.SUPPORT_QUERY_HANDLE_LIST);
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
    public List<String> supportOnlineList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportOnlineLocator.SUPPORT_ONLINE_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportOnlineLocator.SUPPORT_ONLINE_LIST);
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
