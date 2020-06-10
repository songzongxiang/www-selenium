package com.sh.stt.testcase.common;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.common.PageCommon;
import com.sh.stt.data.WWWData;
import com.sh.stt.locator.IndexCommonLocator;
import com.sh.stt.page.IndexCommonPage;
import com.sh.stt.util.Assertion;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 首页共有部分 页面测试用例
 */
@Feature("首页共有部分--页头/页脚/咪咕娱乐/智能硬件/特色专区/公告/国资动态")
@Slf4j
public class IndexCommonTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //页面操作方法
    public PageCommon pc;
    //首页共有部分页面对象
    public IndexCommonPage indexCommonPage;

    @BeforeClass
    public void beforeClass() {
        bp = new BasePage(driver);
        pc = new PageCommon(driver);
        indexCommonPage = new IndexCommonPage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.BJ_INDEX_URL);
        log.info("进入 门户首页 页面");
    }

    /**
     * 页头
     */
    @Story("页头")
    @Test
    public void headListTest() {
        log.info("页头");
        //获取所有text的List集合
        List<String> listString = indexCommonPage.headList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.back();
        }
    }

    /**
     * 搜索关键字
     */
    @Story("搜索关键字")
    @Test
    public void searchKeyWordTest() {
        log.info("搜索关键字");
        bp.sendInput(IndexCommonLocator.SEARCH_INPUT, WWWData.INDEX_SEARCH_TEXT);
        bp.clickButton(IndexCommonLocator.SEARCH_BUTTON);
        // 所有窗口句柄
        Set<String> allHandles = driver.getWindowHandles();
        // 寻找下一个句柄
        for (String handle:allHandles){
            if (handle.equals(bp.currentHandle)){ //如果为 最先的窗口 权柄跳出
                continue;
            }
            driver.switchTo().window(handle); //如果不为最先的窗口权柄，将新窗口的操作权柄给driver
            Assertion.verifyEquals(driver.getTitle(), "5G_网页搜索_中国移动", "跟期望标题不一致" + "，当前URL:" + driver.getCurrentUrl());
            driver.close(); //关闭新弹出的浏览器窗口
            driver.switchTo().window(bp.currentHandle); //回到原始的浏览器窗口
        }
    }

    /**
     * 搜索热词
     */
    @Story("搜索热词")
    @Test
    public void searchHotListTest() {
        log.info("搜索热词");
        //获取所有text的List集合
        List<String> listString = indexCommonPage.searchHotList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.switchNextHandle();
        }
    }

    /**
     * 4F 智能硬件-内容区
     */
    @Story("4F 智能硬件-内容区")
    @Test
    public void intelHardListTest() {
        log.info("4F 智能硬件-内容区");
        //获取所有wtcode的List集合
        List<String> listString = indexCommonPage.intelHardList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 5F 咪咕娱乐-焦点图
     */
    @Story("5F 咪咕娱乐-焦点图")
    @Test
    public void miguBannerTest() {
        log.info("5F 咪咕娱乐-焦点图");
        //获取所有title的List集合
        List<String> listString = indexCommonPage.miguBannerList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//img[@title='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 5F 咪咕娱乐-流行乐风向标
     */
    @Story("5F 咪咕娱乐-流行乐风向标")
    @Test
    public void miguAlbumTest() {
        log.info("5F 咪咕娱乐-流行乐风向标");
        //获取所有title的List集合
        List<String> listString = indexCommonPage.miguAlbumList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//img[@title='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 5F 咪咕娱乐-热词
     */
    @Story("5F 咪咕娱乐-热词")
    @Test
    public void miguHotWordTest() {
        log.info("5F 咪咕娱乐-热词");
        //获取所有wtcode的List集合
        List<String> listString = indexCommonPage.miguHotWordList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 特色专区
     */
    @Story("特色专区")
    @Test
    public void featureListTest(){
        log.info("特色专区");
        //获取所有text的List集合
        List<String> listString = indexCommonPage.featureList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.switchNextHandle();
        }
    }

    /**
     * 公告
     */
    @Story("公告")
    @Test
    public void noticeListTest(){
        log.info("公告");
        //获取所有title的List集合
        List<String> listString = indexCommonPage.noticeList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@title='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 国资动态
     */
    @Story("国资动态")
    @Test
    public void gzdtListTest(){
        log.info("国资动态");
        //获取所有title的List集合
        List<String> listString = indexCommonPage.gzdtList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@title='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 页脚带target
     */
    @Story("页脚带target")
    @Test
    public void footerTargetListTest() {
        log.info("页脚带target");
        //获取所有text的List集合
        List<String> listString = indexCommonPage.footerTargetList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.switchNextHandle();
        }
    }

    /**
     * 页脚不带target
     */
    @Story("页脚不带target")
    @Test
    public void footerNotTargetListTest() throws InterruptedException {
        log.info("页脚不带target");
        //获取所有text的List集合
        List<String> listString = indexCommonPage.footerNotTargetList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[contains(text(),'"+listString.get(i)+"')]")));
            bp.back();
        }
    }

    /**
     * 页脚底部
     */
    @Story("页脚底部")
    @Test
    public void footerBottomTest(){
        log.info("页脚底部");
        //打击传销
        if (pc.isElementExist(IndexCommonLocator.DJCX_BUTTON, 2)) {
            WebElement DJCXEle = driver.findElement(IndexCommonLocator.DJCX_BUTTON);
            bp.scrollElementTopToTop(IndexCommonLocator.DJCX_BUTTON);
            DJCXEle.click();
            bp.back();
        }
        //营业厅
        if (pc.isElementExist(IndexCommonLocator.YYT_BUTTON, 2)) {
            WebElement YYTEle = driver.findElement(IndexCommonLocator.YYT_BUTTON);
            bp.scrollElementTopToTop(IndexCommonLocator.YYT_BUTTON);
            YYTEle.click();
            bp.back();
        }
        //中国移动客户端下载
        if (pc.isElementExist(IndexCommonLocator.APP_BUTTON, 2)) {
            WebElement APPEle = driver.findElement(IndexCommonLocator.APP_BUTTON);
            bp.scrollElementTopToTop(IndexCommonLocator.APP_BUTTON);
            APPEle.click();
            bp.back();
        }
        //可信网站
        if (pc.isElementExist(IndexCommonLocator.KXWZ_BUTTON, 2)) {
            WebElement KXWZEle = driver.findElement(IndexCommonLocator.KXWZ_BUTTON);
            bp.scrollElementTopToTop(IndexCommonLocator.KXWZ_BUTTON);
            KXWZEle.click();
            bp.switchNextHandle();
        }
        //京ICP备05002571号
        if (pc.isElementExist(IndexCommonLocator.GOV_BUTTON, 2)) {
            WebElement govEle = driver.findElement(IndexCommonLocator.GOV_BUTTON);
            bp.scrollElementTopToTop(IndexCommonLocator.GOV_BUTTON);
            govEle.click();
            bp.back();
        }
    }

}
