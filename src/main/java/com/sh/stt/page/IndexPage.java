package com.sh.stt.page;

import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.IndexLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 门户首页 页面对象
 */
public class IndexPage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public IndexPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有主广告区--轮播图的List集合
     */
    public List<String> advCarList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.ADV_CAR_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexLocator.ADV_CAR_LIST);
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
     * 获取所有快捷专区功能区的List集合
     */
    public List<String> quickList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.QUICK_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexLocator.QUICK_LIST);
            for (WebElement element:listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("alt"));
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有左导航--办业务dtdd的List集合
     */
    public List<String> businessDddtList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.BUSINESS_DT_CONTENT_LIST, 2)){
            //获取dt所有列表
            List<WebElement> dtListElement = findElements(IndexLocator.BUSINESS_DT_CONTENT_LIST);
            for (WebElement element:dtListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        //判断元素是否存在
        if (isElementExist(IndexLocator.BUSINESS_DD_CONTENT_LIST, 2)){
            //获取dd所有列表
            List<WebElement> ddListElement = findElements(IndexLocator.BUSINESS_DD_CONTENT_LIST);
            for (WebElement element:ddListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有左导航--买手机dtdd的List集合
     */
    public List<String> mobileDddtList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.MOBILE_DT_CONTENT_LIST, 2)){
            //获取dt所有列表
            List<WebElement> dtListElement = findElements(IndexLocator.MOBILE_DT_CONTENT_LIST);
            for (WebElement element:dtListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        //判断元素是否存在
        if (isElementExist(IndexLocator.MOBILE_DD_CONTENT_LIST, 2)){
            //获取dd所有列表
            List<WebElement> ddListElement = findElements(IndexLocator.MOBILE_DD_CONTENT_LIST);
            for (WebElement element:ddListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有左导航--套餐/靓号dtdd的List集合
     */
    public List<String> packageDddtList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.PACKAGE_DT_CONTENT_LIST, 2)){
            //获取dt所有列表
            List<WebElement> dtListElement = findElements(IndexLocator.PACKAGE_DT_CONTENT_LIST);
            for (WebElement element:dtListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        //判断元素是否存在
        if (isElementExist(IndexLocator.PACKAGE_DD_CONTENT_LIST, 2)){
            //获取dd所有列表
            List<WebElement> ddListElement = findElements(IndexLocator.PACKAGE_DD_CONTENT_LIST);
            for (WebElement element:ddListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有左导航--家庭业务dtdd的List集合
     */
    public List<String> familyServiceDddtList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.FAMILY_SERVICE_DT_CONTENT_LIST, 2)){
            //获取dt所有列表
            List<WebElement> dtListElement = findElements(IndexLocator.FAMILY_SERVICE_DT_CONTENT_LIST);
            for (WebElement element:dtListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        //判断元素是否存在
        if (isElementExist(IndexLocator.FAMILY_SERVICE_DD_CONTENT_LIST, 2)){
            //获取dd所有列表
            List<WebElement> ddListElement = findElements(IndexLocator.FAMILY_SERVICE_DD_CONTENT_LIST);
            for (WebElement element:ddListElement) {//判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有左导航--智能硬件dtdd的List集合
     */
    public List<String> intelHardDddtList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.INTEL_HARD_DT_CONTENT_LIST, 2)){
            //获取dt所有列表
            List<WebElement> dtListElement = findElements(IndexLocator.INTEL_HARD_DT_CONTENT_LIST);
            for (WebElement element:dtListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        //判断元素是否存在
        if (isElementExist(IndexLocator.INTEL_HARD_DD_CONTENT_LIST, 2)){
            //获取dd所有列表
            List<WebElement> ddListElement = findElements(IndexLocator.INTEL_HARD_DD_CONTENT_LIST);
            for (WebElement element:ddListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有左导航--查询服务dtdd的List集合
     */
    public List<String> queryServiceDddtList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.QUERY_SERVICE_DT_CONTENT_LIST, 2)){
            //获取dt所有列表
            List<WebElement> dtListElement = findElements(IndexLocator.QUERY_SERVICE_DT_CONTENT_LIST);
            for (WebElement element:dtListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        //判断元素是否存在
        if (isElementExist(IndexLocator.QUERY_SERVICE_DD_CONTENT_LIST, 2)){
            //获取dd所有列表
            List<WebElement> ddListElement = findElements(IndexLocator.QUERY_SERVICE_DD_CONTENT_LIST);
            for (WebElement element:ddListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有左导航--特色专区dtdd的List集合
     */
    public List<String> featureDddtList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.FEATURE_DT_CONTENT_LIST, 2)){
            //获取dt所有列表
            List<WebElement> dtListElement = findElements(IndexLocator.FEATURE_DT_CONTENT_LIST);
            for (WebElement element:dtListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        //判断元素是否存在
        if (isElementExist(IndexLocator.FEATURE_DD_CONTENT_LIST, 2)){
            //获取dd所有列表
            List<WebElement> ddListElement = findElements(IndexLocator.FEATURE_DD_CONTENT_LIST);
            for (WebElement element:ddListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有推荐营销位右侧轮播区的List集合
     */
    public List<String> yhgundongList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.YH_GUNDONG_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexLocator.YH_GUNDONG_LIST);
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
     * 获取所有享优惠的List集合
     */
    public List<String> eventsList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.EVENTS_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexLocator.EVENTS_LIST);
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
     * 获取所有业务推荐的List集合
     */
    public List<String> operateList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.OPERATE_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexLocator.OPERATE_LIST);
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
     * 获取所有手机专区的List集合
     */
    public List<String> mobileList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.MOBILE_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexLocator.MOBILE_LIST);
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
     * 获取所有自定义楼层的List集合
     */
    public List<String> customList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.CUSTOM_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexLocator.CUSTOM_LIST);
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
     * 获取所有底部链接区的List集合
     */
    public List<String> bottomList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.BOTTOM_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexLocator.BOTTOM_LIST);
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
     * 获取所有右侧在线客服的List集合
     */
    public List<String> onlineServiceList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexLocator.ONLINE_SERVICE_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexLocator.ONLINE_SERVICE_LIST);
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
