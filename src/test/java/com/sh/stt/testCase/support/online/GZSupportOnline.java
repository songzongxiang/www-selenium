package com.sh.stt.testCase.support.online;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.support.SupportOnlinePagePro;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Feature("服务中心--客户服务--贵州网上营业厅")
public class GZSupportOnline extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/support/service/channel/online/gz/");
    }

    /**
     * 客户服务--网上营业厅
     */
    @Story("客户服务--网上营业厅--查询办理")
    @Test
    public void supportQueryHandleListTest() {
        //获取所有text的List集合
        List<String> listString = SupportOnlinePagePro.supportQueryHandleList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            back();
        }
    }

    /**
     * 客户服务--网上营业厅
     */
    @Story("客户服务--网上营业厅--其他商城专区")
    @Test
    public void supportOnlineListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = SupportOnlinePagePro.supportOnlineList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            getWindowsHandle();
        }
    }

}
