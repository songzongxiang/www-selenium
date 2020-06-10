package com.sh.stt.page;

import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.FeeLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 资费专区 页面对象
 */
public class FeePage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public FeePage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有基础套餐/可选包内容的List集合
     */
    public List<String> feeContentList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(FeeLocator.FEE_CONTENT_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(FeeLocator.FEE_CONTENT_LIST);
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
