package com.sh.stt.page.support;

import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.support.SupportEntityLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务中心--客户服务--实体营业厅 页面对象
 */
public class SupportEntityPage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public SupportEntityPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有实体营业厅的List集合
     */
    public List<String> supportEntityList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(SupportEntityLocator.SUPPORT_ENTITY_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(SupportEntityLocator.SUPPORT_ENTITY_LIST);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("khfw_styyt_map"));
                }
            }
        }
        return listString;
    }

}
