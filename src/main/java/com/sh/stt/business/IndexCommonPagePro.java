package com.sh.stt.business;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.page.IndexCommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页共有部分
 */
public class IndexCommonPagePro {

    /**
     * 获取所有页头的List集合
     */
    public static List<String> headList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexCommonPage.headList, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexCommonPage.headList);
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
     * 获取所有搜索热词的List集合
     */
    public static List<String> searchHotList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexCommonPage.searchHot, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexCommonPage.searchHot);
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
     * 获取所有智能硬件的List集合
     */
    public static List<String> intelHardList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexCommonPage.intelHardListEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexCommonPage.intelHardListEle);
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
     * 获取所有咪咕娱乐的List集合
     */
    public static List<String> miguList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexCommonPage.miguContentEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexCommonPage.miguContentEle);
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
     * 获取咪咕娱乐-咪咕音乐右侧页码的集合
     */
    public static List<String> pageNumMiguMusic(WebDriver driver) {
        // 定义一个List集合，用来保存pageNum
        List<String> pageNumList = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexCommonPage.miguMusicIconEle, 2)){
            // 获取右侧页码img图标的集合
            List<WebElement> listElement = driver.findElements(IndexCommonPage.miguMusicIconEle);
            for (WebElement element : listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    pageNumList.add(element.getText());
                }
            }
        }
        return pageNumList;
    }

    /**
     * 获取咪咕娱乐-咪咕游戏右侧页码的集合
     */
    public static List<String> pageNumMiguGame(WebDriver driver) {
        // 定义一个List集合，用来保存pageNum
        List<String> pageNumList = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexCommonPage.miguGameIconEle, 2)){
            // 获取右侧页码img图标的集合
            List<WebElement> listElement = driver.findElements(IndexCommonPage.miguGameIconEle);
            for (WebElement element : listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    pageNumList.add(element.getText());
                }
            }
        }
        return pageNumList;
    }

    /**
     * 获取咪咕娱乐-咪咕阅读右侧页码的集合
     */
    public static List<String> pageNumMiguRead(WebDriver driver) {
        // 定义一个List集合，用来保存pageNum
        List<String> pageNumList = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexCommonPage.miguReadIconEle, 2)){
            // 获取右侧页码img图标的集合
            List<WebElement> listElement = driver.findElements(IndexCommonPage.miguReadIconEle);
            for (WebElement element : listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    pageNumList.add(element.getText());
                }
            }
        }
        return pageNumList;
    }

    /**
     * 获取咪咕娱乐-咪咕圈圈右侧页码的集合
     */
    public static List<String> pageNumMiguAnime(WebDriver driver) {
        // 定义一个List集合，用来保存pageNum
        List<String> pageNumList = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexCommonPage.miguAnimeIconEle, 2)){
            // 获取右侧页码img图标的集合
            List<WebElement> listElement = driver.findElements(IndexCommonPage.miguAnimeIconEle);
            for (WebElement element : listElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(element.isDisplayed() == true){
                    pageNumList.add(element.getText());
                }
            }
        }
        return pageNumList;
    }

    /**
     * 获取咪咕娱乐-焦点图的List集合
     */
    public static List<String> miguBannerList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexCommonPage.miguBannerEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexCommonPage.miguBannerEle);
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
     * 获取咪咕娱乐-流行乐风向标的List集合
     */
    public static List<String> miguAlbumList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexCommonPage.miguAlbumContentEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexCommonPage.miguAlbumContentEle);
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
     * 获取咪咕娱乐-右侧热词的List集合
     */
    public static List<String> miguHotWordList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexCommonPage.miguHotWordEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexCommonPage.miguHotWordEle);
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
        if (BaseDriver.isElementExist(driver, IndexCommonPage.featureEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexCommonPage.featureEle);
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
        if (BaseDriver.isElementExist(driver, IndexCommonPage.noticeEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexCommonPage.noticeEle);
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
        if (BaseDriver.isElementExist(driver, IndexCommonPage.gzdtEle, 2)){
            //获取所有列表
            List<WebElement> listElement = driver.findElements(IndexCommonPage.gzdtEle);
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
     * 获取所有页脚带target的List集合
     */
    public static List<String> footerTargetList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexCommonPage.footerTargetList, 2)){
            //获取所有带target列表
            List<WebElement> targetListElement = driver.findElements(IndexCommonPage.footerTargetList);
            for (WebElement targetEle:targetListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(targetEle.isDisplayed() == true){
                    listString.add(targetEle.getText());
                }
            }
        }
        return listString;
    }

    /**
     * 获取所有页脚不带target的List集合
     */
    public static List<String> footerNorTargetList(WebDriver driver){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, IndexCommonPage.footerNotTargetList, 2)){
            //获取所有不带target列表
            List<WebElement> notTargetListElement = driver.findElements(IndexCommonPage.footerNotTargetList);
            for (WebElement notTargetEle:notTargetListElement) {
                //判断元素是否显示--解决页面style="display: none;"
                if(notTargetEle.isDisplayed() == true){
                    listString.add(notTargetEle.getText());
                }
            }
        }
        return listString;
    }

}
