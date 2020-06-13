package com.sh.stt.testcase.common;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.common.PageCommon;
import com.sh.stt.data.WWWData;
import com.sh.stt.page.support.SupportIndexPage;
import com.sh.stt.locator.support.SupportIndexLocator;
import com.sh.stt.util.Assertion;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 服务中心首页公共部分 页面测试用例
 */
@Feature("服务中心首页公共部分")
@Slf4j
public class SupportIndexCommonTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //页面操作方法
    public PageCommon pc;
    //服务中心首页页面对象
    public SupportIndexPage supportIndexPage;

    @BeforeMethod
    public void beforeMethod() {
        bp = new BasePage(driver);
        supportIndexPage = new SupportIndexPage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.BJ_SUPPORT_INDEX_URL);
        log.info("进入 服务中心首页 页面");
    }

    /**
     * 服务中心--购物指南
     */
    @Story("服务中心首页--购物指南")
    @Test
    public void supportGouwuconListTest() {
        log.info("购物指南");
        //获取所有text的List集合
        List<String> listString = supportIndexPage.supportGouwuconList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.switchNextHandle();
        }
    }

    /**
     * 服务中心--商城帮助
     */
    @Story("服务中心首页--商城帮助")
    @Test
    public void supportScHelpListTest() {
        log.info("商城帮助");
        //获取所有text的List集合
        List<String> listString = supportIndexPage.supportScHelpList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.switchNextHandle();
        }
    }

    /**
     * 服务中心--搜索答案
     */
    @Story("服务中心首页--搜索答案")
    @Test
    public void supportSearchTest() {
        log.info("搜索答案");
        bp.sendInput(SupportIndexLocator.EleSUPPORT_SEARCH_INPUT, WWWData.SUPPORT_SEARCH_TEXT);
        bp.clickButton(SupportIndexLocator.SUPPORT_SEARCH_BUTTON);
        // 所有窗口句柄
        Set<String> allHandles = driver.getWindowHandles();
        // 寻找下一个句柄
        for (String handle:allHandles){
            if (handle.equals(bp.currentHandle)){ //如果为 最先的窗口 权柄跳出
                continue;
            }
            driver.switchTo().window(handle); //如果不为最先的窗口权柄，将新窗口的操作权柄给driver
            Assertion.verifyEquals(driver.getCurrentUrl(), "http://www.10086.cn/support/selfservice/help/helpresult/bj/?key=10086", "跟期望URL不一致" + "，当前URL:" + driver.getCurrentUrl());
            driver.close(); //关闭新弹出的浏览器窗口
            driver.switchTo().window(bp.currentHandle); //回到原始的浏览器窗口
        }
    }

    /**
     * 服务中心--问答
     */
    @Story("服务中心首页--问答")
    @Test
    public void supportFAQListTest() {
        log.info("问答");
        //获取所有text的List集合
        List<String> listString = supportIndexPage.supportFAQList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.switchNextHandle();
        }
    }

}
