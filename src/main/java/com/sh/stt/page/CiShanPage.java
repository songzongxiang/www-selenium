package com.sh.stt.page;

import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.CiShanLocator;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 慈善基金会 页面对象
 */
public class CiShanPage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public CiShanPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有页头导航区内容的List集合
     */
    public List<String> headNavList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(CiShanLocator.HEAD_NAV_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(CiShanLocator.HEAD_NAV_LIST);
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
    public List<String> csLinkList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(CiShanLocator.CS_LINK_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(CiShanLocator.CS_LINK_LIST);
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
