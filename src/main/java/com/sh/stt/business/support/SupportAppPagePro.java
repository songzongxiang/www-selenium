package com.sh.stt.business.support;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.support.SupportAppPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务中心--终端应用--客户端下载业务层
 */
public class SupportAppPagePro {

    /**
     * 获取所有终端应用--客户端下载的List集合
     */
    public static List<String> supportAppList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportAppPage.supportAppContent, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportAppPage.supportAppContent);
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
     * 获取客户端下载底部页码的集合
     */
    public static List<Integer> pageNumSupportAppNextButton(WebDriver driver) {
        // 定义一个List集合，用来保存pageNum
        List<Integer> pageNumList = new ArrayList<Integer>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportAppPage.supportAppNextEles, 2)){
            // 获取右侧页码img图标的集合
            List<WebElement> listElement = driver.findElements(SupportAppPage.supportAppNextEles);
            for (WebElement element : listElement) {
                String pageNum = element.getText();
                if (BaseDriver.isNumber(pageNum)){
                    pageNumList.add(Integer.parseInt(pageNum));
                }
            }
        }
        return pageNumList;
    }

}
