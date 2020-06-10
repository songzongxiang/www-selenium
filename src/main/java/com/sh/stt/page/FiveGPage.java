package com.sh.stt.page;

import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.FiveGLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 5G专区 页面对象
 */
public class FiveGPage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public FiveGPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有快捷入口内容的List集合
     */
    public List<String> quickContentList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(FiveGLocator.FIVEG_QUICK_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(FiveGLocator.FIVEG_QUICK_LIST);
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
     * 获取所有5G套餐内容的List集合
     */
    public List<String> packageContentList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(FiveGLocator.FIVEG_PACKAGE_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(FiveGLocator.FIVEG_PACKAGE_LIST);
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
     * 获取所有5G终端内容的List集合
     */
    public List<String> phoneContentList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(FiveGLocator.FIVEG_PHONE_CONTENT_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(FiveGLocator.FIVEG_PHONE_CONTENT_LIST);
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
     * 获取所有5G终端--轮播内容的List集合
     */
    public List<String> phoneCarouselContentList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(FiveGLocator.FIVEG_CAROUSEL_CONTENT_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(FiveGLocator.FIVEG_CAROUSEL_CONTENT_LIST);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("href"));
                }
            }
        }
        return listString;
    }

}
