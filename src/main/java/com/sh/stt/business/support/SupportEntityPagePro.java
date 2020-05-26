package com.sh.stt.business.support;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.support.SupportEntityPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务中心--客户服务--实体营业厅业务层
 */
public class SupportEntityPagePro {

    /**
     * 获取所有实体营业厅的List集合
     */
    public static List<String> supportEntityList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, SupportEntityPage.supportEntityEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(SupportEntityPage.supportEntityEle);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("khfw_styyt_map"));
                    System.out.println(element.getAttribute("khfw_styyt_map"));
                }
            }
        }
        return listString;
    }

}
