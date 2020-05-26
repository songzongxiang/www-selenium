package com.sh.stt.testCase.support.events;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.support.SupportEventsPagePro;
import com.sh.stt.page.support.SupportEventsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Feature("服务中心--客户服务--江西优惠专区")
public class JXSupportEvents extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/support/service/events/jx/index_791_791.html");
    }

    /**
     * 客户服务--优惠专区--内容区
     */
    @Story("优惠专区--内容区")
    @Test
    public void supportEventsContentListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        List<Integer> pageNumList = SupportEventsPagePro.pageNumSupportEventsNextButton(driver);
        for (int i = 0; i < pageNumList.size(); i++) {
            //获取所有text的List集合
            List<String> listString = SupportEventsPagePro.supportEventsContentList(driver);
            for (int j = 0; j < listString.size(); j++) {
                int count = Collections.frequency(listString, listString.get(j)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(j)+"')]")));
                getWindowsHandle();
            }
            //判断元素是否存在
            if (BaseDriver.isElementExist(driver, SupportEventsPage.supportEventsNextEle, 2)) {
                //点击下一页
                driver.findElement(SupportEventsPage.supportEventsNextEle).click();
            }
        }
    }

}
