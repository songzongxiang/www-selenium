package com.sh.stt.page.support;

import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.support.SupportAppLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务中心--终端应用--客户端下载 页面对象
 */
public class SupportAppPage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public SupportAppPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有终端应用--客户端下载的List集合
     */
    public List<String> supportAppList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportAppLocator.SUPPORT_APP_CONTENT_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportAppLocator.SUPPORT_APP_CONTENT_LIST);
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
    public List<Integer> pageNumSupportAppNextButton() {
        // 定义一个List集合，用来保存pageNum
        List<Integer> pageNumList = new ArrayList<Integer>();
        //判断元素是否存在
        if (isElementExist(SupportAppLocator.SUPPORT_APP_NEXT_BUTTON_LIST, 2)){
            // 获取右侧页码img图标的集合
            List<WebElement> listElement = findElements(SupportAppLocator.SUPPORT_APP_NEXT_BUTTON_LIST);
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
