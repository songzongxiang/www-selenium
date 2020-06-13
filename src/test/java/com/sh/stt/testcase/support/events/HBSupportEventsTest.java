package com.sh.stt.testcase.support.events;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.common.PageCommon;
import com.sh.stt.data.WWWData;
import com.sh.stt.locator.support.SupportEventsLocator;
import com.sh.stt.page.support.SupportEventsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * 服务中心--客户服务--湖北优惠专区 页面测试用例
 */
@Feature("服务中心--客户服务--湖北优惠专区")
@Slf4j
public class HBSupportEventsTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //页面操作方法
    public PageCommon pc;
    //服务中心--客户服务--优惠专区页面对象
    public SupportEventsPage supportEventsPage;

    @BeforeMethod
    public void beforeMethod() {
        bp = new BasePage(driver);
        pc = new PageCommon(driver);
        supportEventsPage = new SupportEventsPage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.HB_SUPPORT_EVENTS_URL);
        log.info("进入 服务中心--客户服务--湖北优惠专区 页面");
    }

    /**
     * 客户服务--优惠专区--内容区
     */
    @Story("优惠专区--内容区")
    @Test
    public void supportEventsContentListTest() {
        List<Integer> pageNumList = supportEventsPage.pageNumSupportEventsNextButton();
        for (int i = 0; i < pageNumList.size(); i++) {
            //获取所有text的List集合
            List<String> listString = supportEventsPage.supportEventsContentList();
            for (int j = 0; j < listString.size(); j++) {
                int count = Collections.frequency(listString, listString.get(j)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(j)+"')]")));
                bp.switchNextHandle();
            }
            //判断元素是否存在
            if (pc.isElementExist(SupportEventsLocator.SUPPORT_EVENTS_NEXT_BUTTON, 2)) {
                //点击下一页
                driver.findElement(SupportEventsLocator.SUPPORT_EVENTS_NEXT_BUTTON).click();
            }
        }
    }

}
