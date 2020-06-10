package com.sh.stt.page;

import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.KDTSJFLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 宽带提速降费 页面对象
 */
public class KDTSJFPage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public KDTSJFPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有宽带提速降费--宽带新装的List集合
     */
    public List<String> broadbandNewClothesList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(KDTSJFLocator.BROADBAND_NEW_CLOTHES_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(KDTSJFLocator.BROADBAND_NEW_CLOTHES_LIST);
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
     * 获取所有宽带提速降费--宽带升级的List集合
     */
    public List<String> broadbandUpgradeList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(KDTSJFLocator.BROADBAND_UPGRADE_LIST, 2)) {
            //获取所有列表
            List<WebElement> listElement = findElements(KDTSJFLocator.BROADBAND_UPGRADE_LIST);
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
