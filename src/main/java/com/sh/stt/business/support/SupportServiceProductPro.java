package com.sh.stt.business.support;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.support.SupportServiceProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务中心--业务资费--产品业务层
 */
public class SupportServiceProductPro {

    /**
     * 获取所有业务资费--产品的List集合
     */
    public static List<String> supportServiceProductList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportServiceProductPage.supportServiceProduct, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportServiceProductPage.supportServiceProduct);
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
    public static List<String> supportServiceProductDelList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportServiceProductPage.supportServiceProductDel, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportServiceProductPage.supportServiceProductDel);
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
