package com.sh.stt.page;

import com.sh.stt.common.PageCommon;
import com.sh.stt.locator.IndexCommonLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页共有部分 页面对象
 */
public class IndexCommonPage extends PageCommon {

    /**
     * 构造器
     *
     * @param driver 驱动
     */
    public IndexCommonPage(WebDriver driver) {
        super(driver);
    }

    /**
     * 获取所有页头的List集合
     */
    public List<String> headList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexCommonLocator.HEAD_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexCommonLocator.HEAD_LIST);
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
    public List<String> searchHotList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexCommonLocator.SEARCH_HOT_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexCommonLocator.SEARCH_HOT_LIST);
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
    public List<String> intelHardList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexCommonLocator.INTEL_HARD_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexCommonLocator.INTEL_HARD_LIST);
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
     * 获取咪咕娱乐-焦点图的List集合
     */
    public List<String> miguBannerList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexCommonLocator.MIGU_BANNER_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexCommonLocator.MIGU_BANNER_LIST);
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
    public List<String> miguAlbumList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexCommonLocator.MIGU_ALBUM_CONTENT_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexCommonLocator.MIGU_ALBUM_CONTENT_LIST);
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
    public List<String> miguHotWordList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexCommonLocator.MIGU_HOT_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexCommonLocator.MIGU_HOT_LIST);
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
    public List<String> featureList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexCommonLocator.FEATURE_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexCommonLocator.FEATURE_LIST);
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
    public List<String> noticeList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexCommonLocator.NOTICE_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexCommonLocator.NOTICE_LIST);
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
    public List<String> gzdtList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexCommonLocator.GZDT_LIST, 2)){
            //获取所有列表
            List<WebElement> listElement = findElements(IndexCommonLocator.GZDT_LIST);
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
    public List<String> footerTargetList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexCommonLocator.FOOTER_TARGET_LIST, 2)){
            //获取所有带target列表
            List<WebElement> targetListElement = findElements(IndexCommonLocator.FOOTER_TARGET_LIST);
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
    public List<String> footerNotTargetList(){
        List<String> listString = new ArrayList<String>();
        //判断元素是否存在
        if (isElementExist(IndexCommonLocator.FOOTER_NOT_TARGET_LIST, 2)){
            //获取所有不带target列表
            List<WebElement> notTargetListElement = findElements(IndexCommonLocator.FOOTER_NOT_TARGET_LIST);
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
