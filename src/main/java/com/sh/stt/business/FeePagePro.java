package com.sh.stt.business;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.FeePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 资费专区业务层
 */
public class FeePagePro {

    /**
     * 获取所有基础套餐/可选包内容的List集合
     */
    public static List<String> feeContentList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, FeePage.feeContentEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(FeePage.feeContentEle);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        return listString;
    }

}
