package com.sh.stt.business;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.IndexPage;
import com.sh.stt.page.IndexPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class IndexPagePro {

    /**
     * 获取所有主广告区--轮播图的List集合
     */
    public static List<String> advCarList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.advCarList, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexPage.advCarList);
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
    public static List<String> quickList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.quickList, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexPage.quickList);
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
    public static List<String> businessDddtList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.businessdtContent, 2)){
            //获取dt所有列表
            List<WebElement> dtListElement = driver.findElements(IndexPage.businessdtContent);
            for (WebElement element:dtListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.businessddContent, 2)){
            //获取dd所有列表
            List<WebElement> ddListElement = driver.findElements(IndexPage.businessddContent);
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
    public static List<String> mobileDddtList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.mobiledtContent, 2)){
            //获取dt所有列表
            List<WebElement> dtListElement = driver.findElements(IndexPage.mobiledtContent);
            for (WebElement element:dtListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.mobileddContent, 2)){
            //获取dd所有列表
            List<WebElement> ddListElement = driver.findElements(IndexPage.mobileddContent);
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
    public static List<String> packageDddtList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.packagedtContent, 2)){
            //获取dt所有列表
            List<WebElement> dtListElement = driver.findElements(IndexPage.packagedtContent);
            for (WebElement element:dtListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.packageddContent, 2)){
            //获取dd所有列表
            List<WebElement> ddListElement = driver.findElements(IndexPage.packageddContent);
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
    public static List<String> familyBusDddtList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.familyBusdtContent, 2)){
            //获取dt所有列表
            List<WebElement> dtListElement = driver.findElements(IndexPage.familyBusdtContent);
            for (WebElement element:dtListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.familyBusddContent, 2)){
            //获取dd所有列表
            List<WebElement> ddListElement = driver.findElements(IndexPage.familyBusddContent);
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
    public static List<String> intelHardDddtList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.intelHarddtContent, 2)){
            //获取dt所有列表
            List<WebElement> dtListElement = driver.findElements(IndexPage.intelHarddtContent);
            for (WebElement element:dtListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.intelHardddContent, 2)){
            //获取dd所有列表
            List<WebElement> ddListElement = driver.findElements(IndexPage.intelHardddContent);
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
    public static List<String> queryServiceDddtList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.queryServicedtContent, 2)){
            //获取dt所有列表
            List<WebElement> dtListElement = driver.findElements(IndexPage.queryServicedtContent);
            for (WebElement element:dtListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.queryServiceddContent, 2)){
            //获取dd所有列表
            List<WebElement> ddListElement = driver.findElements(IndexPage.queryServiceddContent);
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
    public static List<String> featureDddtList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.featuredtContent, 2)){
            //获取dt所有列表
            List<WebElement> dtListElement = driver.findElements(IndexPage.featuredtContent);
            for (WebElement element:dtListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    listString.add(element.getAttribute("wtcode"));
                }
            }
        }
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.featureddContent, 2)){
            //获取dd所有列表
            List<WebElement> ddListElement = driver.findElements(IndexPage.featureddContent);
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
    public static List<String> yhgundongList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.yhgundongList, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexPage.yhgundongList);
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
    public static List<String> eventsList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.eventsListEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexPage.eventsListEle);
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
    public static List<String> operateList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.operateListEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexPage.operateListEle);
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
    public static List<String> mobileList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.mobileListEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexPage.mobileListEle);
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
     * 获取所有智能硬件的List集合
     */
    public static List<String> intelHardList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.intelHardListEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexPage.intelHardListEle);
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
    public static List<String> customList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.customListEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexPage.customListEle);
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
     * 获取所有特色专区的List集合
     */
    public static List<String> featureList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.featureEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexPage.featureEle);
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
     * 获取所有公告的List集合
     */
    public static List<String> noticeList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.noticeEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexPage.noticeEle);
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
     * 获取所有国资动态的List集合
     */
    public static List<String> gzdtList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.gzdtEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexPage.gzdtEle);
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
     * 获取所有底部链接区的List集合
     */
    public static List<String> bottomList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexPage.bottomEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexPage.bottomEle);
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
