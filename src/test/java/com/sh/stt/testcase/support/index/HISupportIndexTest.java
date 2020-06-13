package com.sh.stt.testcase.support.index;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.common.PageCommon;
import com.sh.stt.data.WWWData;
import com.sh.stt.page.support.SupportIndexPage;
import com.sh.stt.locator.support.SupportIndexLocator;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * 海南服务中心首页 页面测试用例
 */
@Feature("海南服务中心首页")
@Slf4j
public class HISupportIndexTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //页面操作方法
    public PageCommon pc;
    //服务中心首页页面对象
    public SupportIndexPage supportIndexPage;

    @BeforeMethod
    public void beforeMethod() {
        bp = new BasePage(driver);
        pc = new PageCommon(driver);
        supportIndexPage = new SupportIndexPage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.HI_SUPPORT_INDEX_URL);
        log.info("进入 海南服务中心首页 页面");
    }

    /**
     * 服务中心--主广告区
     */
    @Story("服务中心首页--主广告区")
    @Test
    public void supportBannerListTest() {
        log.info("主广告区");
        //获取所有text的List集合
        List<String> listString = supportIndexPage.supportBannerList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//img[@title='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 服务中心--快捷入口
     */
    @Story("服务中心首页--快捷入口")
    @Test
    public void supportQuickListTest() {
        log.info("快捷入口");
        //获取所有text的List集合
        List<String> listString = supportIndexPage.supportQuickList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@href='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 服务中心--客户服务
     */
    @Story("服务中心首页--客户服务")
    @Test
    public void supportCusServiceListTest() {
        log.info("客户服务");
        if (pc.isElementExist(SupportIndexLocator.SUPPORT_CLASSIFY_LIST, 2)) {
            List<WebElement> elements = bp.findElements(SupportIndexLocator.SUPPORT_CLASSIFY_LIST);
            bp.moveToElement(elements.get(0));
            //获取所有text的List集合
            List<String> listString = supportIndexPage.supportCusServiceList();
            for (int i = 0; i < listString.size(); i++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
                bp.switchNextHandle();
            }
        }
    }

    /**
     * 服务中心--自助专区
     */
    @Story("服务中心首页--自助专区")
    @Test
    public void supportSelfhelpListTest() {
        log.info("自助专区");
        if (pc.isElementExist(SupportIndexLocator.SUPPORT_CLASSIFY_LIST, 2)) {
            List<WebElement> elements = bp.findElements(SupportIndexLocator.SUPPORT_CLASSIFY_LIST);
            bp.moveToElement(elements.get(1));
            //获取所有text的List集合
            List<String> listString = supportIndexPage.supportSelfhelpList();
            for (int i = 0; i < listString.size(); i++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
                bp.switchNextHandle();
            }
        }
    }

    /**
     * 服务中心--业务资费
     */
    @Story("服务中心首页--业务资费")
    @Test
    public void supportServiceFeeListTest() {
        log.info("业务资费");
        if (pc.isElementExist(SupportIndexLocator.SUPPORT_CLASSIFY_LIST, 2)) {
            List<WebElement> elements = bp.findElements(SupportIndexLocator.SUPPORT_CLASSIFY_LIST);
            bp.moveToElement(elements.get(2));
            //获取所有text的List集合
            List<String> listString = supportIndexPage.supportServiceFeeList();
            for (int i = 0; i < listString.size(); i++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
                bp.switchNextHandle();
            }
        }
    }

    /**
     * 服务中心--终端应用
     */
    @Story("服务中心首页--终端应用")
    @Test
    public void supportTerUtiListTest() {
        log.info("终端应用");
        if (pc.isElementExist(SupportIndexLocator.SUPPORT_CLASSIFY_LIST, 2)) {
            List<WebElement> elements = bp.findElements(SupportIndexLocator.SUPPORT_CLASSIFY_LIST);
            bp.moveToElement(elements.get(3));
            //获取所有text的List集合
            List<String> listString = supportIndexPage.supportTerUtiList();
            for (int i = 0; i < listString.size(); i++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
                bp.switchNextHandle();
            }
        }
    }

    /**
     * 服务中心--特色业务说明
     */
    @Story("服务中心首页--特色业务说明")
    @Test
    public void supportTsywconListTest() {
        log.info("特色业务说明");
        //获取所有text的List集合
        List<String> listString = supportIndexPage.supportTsywconList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.switchNextHandle();
        }
    }

}
