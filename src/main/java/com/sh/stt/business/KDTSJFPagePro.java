package com.sh.stt.business;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.KDTSJFPage;
import com.sh.stt.page.KDZQPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class KDTSJFPagePro {

    /**
     * 获取所有宽带提速降费--宽带新装的List集合
     */
    public static List<String> broadbandNewClothesList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, KDTSJFPage.broadbandNewClothesList, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(KDTSJFPage.broadbandNewClothesList);
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
    public static List<String> broadbandUpgradeList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, KDTSJFPage.broadbandUpgradeList, 2)) {
            //获取所有列表
            List<WebElement> listElement = driver.findElements(KDTSJFPage.broadbandUpgradeList);
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
