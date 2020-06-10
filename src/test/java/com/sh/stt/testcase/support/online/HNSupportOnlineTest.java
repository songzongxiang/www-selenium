package com.sh.stt.testcase.support.online;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.data.WWWData;
import com.sh.stt.page.support.SupportOnlinePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * 服务中心--客户服务--湖南网上营业厅 页面测试用例
 */
@Feature("服务中心--客户服务--湖南网上营业厅")
@Slf4j
public class HNSupportOnlineTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //服务中心--客户服务--网上营业厅页面对象
    public SupportOnlinePage supportOnlinePage;

    @BeforeClass
    public void beforeClass() {
        bp = new BasePage(driver);
        supportOnlinePage = new SupportOnlinePage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.HN_SUPPORT_ONLINE_URL);
        log.info("进入 服务中心--客户服务--湖南网上营业厅 页面");
    }

    /**
     * 客户服务--网上营业厅
     */
    @Story("客户服务--网上营业厅--查询办理")
    @Test
    public void supportQueryHandleListTest() {
        log.info("查询办理");
        //获取所有text的List集合
        List<String> listString = supportOnlinePage.supportQueryHandleList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.back();
        }
    }

    /**
     * 客户服务--网上营业厅
     */
    @Story("客户服务--网上营业厅--其他商城专区")
    @Test
    public void supportOnlineListTest() {
        log.info("其他商城专区");
        //获取所有text的List集合
        List<String> listString = supportOnlinePage.supportOnlineList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.switchNextHandle();
        }
    }

}
