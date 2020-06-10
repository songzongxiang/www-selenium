package com.sh.stt.page.support;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.support.SupportEventsLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务中心--客户服务--优惠专区 页面对象
 */
public class SupportEventsPage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public SupportEventsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有优惠专区--内容区的List集合
     */
    public List<String> supportEventsContentList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportEventsLocator.SUPPORT_EVENTS_CONTENT_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportEventsLocator.SUPPORT_EVENTS_CONTENT_LIST);
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
    public List<Integer> pageNumSupportEventsNextButton() {
        // 定义一个List集合，用来保存pageNum
        List<Integer> pageNumList = new ArrayList<Integer>();
        //判断元素是否存在
        if (isElementExist(SupportEventsLocator.SUPPORT_EVENTS_NEXT_BUTTON_LIST, 2)){
            // 获取右侧页码img图标的集合
            List<WebElement> listElement = findElements(SupportEventsLocator.SUPPORT_EVENTS_NEXT_BUTTON_LIST);
            for (WebElement element : listElement) {
                String pageNum = element.getText();
                if (isNumber(pageNum)){
                    pageNumList.add(Integer.parseInt(pageNum));
                }
            }
        }
        return pageNumList;
    }

}
