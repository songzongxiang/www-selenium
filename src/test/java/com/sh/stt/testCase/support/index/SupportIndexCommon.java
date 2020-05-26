package com.sh.stt.testCase.support.index;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.support.SupportIndexPro;
import com.sh.stt.page.support.SupportIndex;
import com.sh.stt.util.Assertion;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Feature("服务中心首页公共部分")
public class SupportIndexCommon extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/support/bj/");
    }

    /**
     * 服务中心--购物指南
     */
    @Story("服务中心首页--购物指南")
    @Test
    public void supportGouwuconListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = SupportIndexPro.supportGouwuconList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            getWindowsHandle();
        }
    }

    /**
     * 服务中心--商城帮助
     */
    @Story("服务中心首页--商城帮助")
    @Test
    public void supportScHelpListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = SupportIndexPro.supportScHelpList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            getWindowsHandle();
        }
    }

    /**
     * 服务中心--搜索答案
     */
    @Story("服务中心首页--搜索答案")
    @Test
    public void supportSearchTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        WebElement keyWordEle = driver.findElement(SupportIndex.supportSearchEle);
        keyWordEle.clear();
        keyWordEle.sendKeys("10086");
        driver.findElement(SupportIndex.supportSeaAnswer).click();
        Set<String> handles = driver.getWindowHandles();
        for (String handle:handles){
            if (handle.equals(windowsHandle)){ //如果为 最先的窗口 权柄跳出
                continue;
            }
            driver.switchTo().window(handle); //如果不为最先的窗口权柄，将新窗口的操作权柄给driver
            Assertion.verifyEquals(driver.getCurrentUrl(), "http://www.10086.cn/support/selfservice/help/helpresult/bj/?key=10086", "跟期望URL不一致" + "，当前URL:" + driver.getCurrentUrl());
            driver.close(); //关闭新弹出的浏览器窗口
            driver.switchTo().window(windowsHandle); //回到原始的浏览器窗口
        }
    }

    /**
     * 服务中心--问答
     */
    @Story("服务中心首页--问答")
    @Test
    public void supportFAQListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = SupportIndexPro.supportFAQList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            getWindowsHandle();
        }
    }

}
