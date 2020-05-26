package com.sh.stt.business.support;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.support.SupportEventsPage;
import com.sh.stt.util.ScrollBarUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 服务中心--客户服务--优惠专区业务层
 */
public class SupportEventsPagePro {

    /**
     * 获取所有优惠专区--内容区的List集合
     */
    public static List<String> supportEventsContentList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportEventsPage.supportEventsContent, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportEventsPage.supportEventsContent);
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
     * 获取内容区底部页码的集合
     */
    public static List<Integer> pageNumSupportEventsNextButton(WebDriver driver) {
        // 定义一个List集合，用来保存pageNum
        List<Integer> pageNumList = new ArrayList<Integer>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportEventsPage.supportEventsNextEles, 2)){
            // 获取右侧页码img图标的集合
            List<WebElement> listElement = driver.findElements(SupportEventsPage.supportEventsNextEles);
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
