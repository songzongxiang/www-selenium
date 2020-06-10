package com.sh.stt.page.support;

import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.support.SupportServiceProductLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务中心--业务资费--产品 页面对象
 */
public class SupportServiceProductPage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public SupportServiceProductPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有业务资费--产品的List集合
     */
    public List<String> supportServiceProductList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportServiceProductLocator.SUPPORT_SERVICE_PRODUCT_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportServiceProductLocator.SUPPORT_SERVICE_PRODUCT_LIST);
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
     * 获取所有业务资费详情--业务专区的List集合
     */
    public List<String> supportServiceProductDelList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportServiceProductLocator.SUPPORT_SERVICE_PRODUCT_DETAILS, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportServiceProductLocator.SUPPORT_SERVICE_PRODUCT_DETAILS);
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
