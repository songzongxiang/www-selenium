package com.sh.stt.page;

import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.KDZQLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 页宽带专区 面对象
 */
public class KDZQPage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public KDZQPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有宽带专区--优质产品的List集合
     */
    public List<String> broadbandProduct(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(KDZQLocator.BROADBAND_PRODUCT, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(KDZQLocator.BROADBAND_PRODUCT);
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
     * 获取所有宽带专区--宽带产品列表的List集合
     */
    public List<String> broadbandProductList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (this.isElementExist(KDZQLocator.BROADBAND_PRODUCT_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(KDZQLocator.BROADBAND_PRODUCT_LIST);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("title"));
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有宽带专区--宽带服务的List集合
     */
    public List<String> broadbandService(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(KDZQLocator.BROADBAND_SERVICE, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(KDZQLocator.BROADBAND_SERVICE);
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
