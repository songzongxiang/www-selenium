package com.sh.stt.testCase.support.index;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.support.SupportIndexPro;
import com.sh.stt.page.support.SupportIndex;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Feature("甘肃服务中心首页")
public class GSSupportIndex extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/support/gs/");
    }

    /**
     * 服务中心--主广告区
     */
    @Story("服务中心首页--主广告区")
    @Test
    public void supportBannerListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = SupportIndexPro.supportBannerList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//img[@title='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 服务中心--快捷入口
     */
    @Story("服务中心首页--快捷入口")
    @Test
    public void supportQuickListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = SupportIndexPro.supportQuickList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 服务中心--客户服务
     */
    @Story("服务中心首页--客户服务")
    @Test
    public void supportCusServiceListTest() {
        if (BaseDriver.isElementExist(driver, SupportIndex.supportClassify, 2)) {
            List<WebElement> elements = driver.findElements(SupportIndex.supportClassify);
            action(elements.get(0));
            windowsHandle = driver.getWindowHandle(); //获取当前handle
            //获取所有text的List集合
            List<String> listString = SupportIndexPro.supportCusServiceList(driver);
            for (int i = 0; i < listString.size(); i++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
                getWindowsHandle();
            }
        }
    }

    /**
     * 服务中心--自助专区
     */
    @Story("服务中心首页--自助专区")
    @Test
    public void supportSelfhelpListTest() {
        if (BaseDriver.isElementExist(driver, SupportIndex.supportClassify, 2)) {
            List<WebElement> elements = driver.findElements(SupportIndex.supportClassify);
            action(elements.get(1));
            windowsHandle = driver.getWindowHandle(); //获取当前handle
            //获取所有text的List集合
            List<String> listString = SupportIndexPro.supportSelfhelpList(driver);
            for (int i = 0; i < listString.size(); i++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
                getWindowsHandle();
            }
        }
    }

    /**
     * 服务中心--业务资费
     */
    @Story("服务中心首页--业务资费")
    @Test
    public void supportServiceFeeListTest() {
        if (BaseDriver.isElementExist(driver, SupportIndex.supportClassify, 2)) {
            List<WebElement> elements = driver.findElements(SupportIndex.supportClassify);
            action(elements.get(2));
            windowsHandle = driver.getWindowHandle(); //获取当前handle
            //获取所有text的List集合
            List<String> listString = SupportIndexPro.supportServiceFeeList(driver);
            for (int i = 0; i < listString.size(); i++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
                getWindowsHandle();
            }
        }
    }

    /**
     * 服务中心--终端应用
     */
    @Story("服务中心首页--终端应用")
    @Test
    public void supportTerUtiListTest() {
        if (BaseDriver.isElementExist(driver, SupportIndex.supportClassify, 2)) {
            List<WebElement> elements = driver.findElements(SupportIndex.supportClassify);
            action(elements.get(3));
            windowsHandle = driver.getWindowHandle(); //获取当前handle
            //获取所有text的List集合
            List<String> listString = SupportIndexPro.supportTerUtiList(driver);
            for (int i = 0; i < listString.size(); i++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
                getWindowsHandle();
            }
        }
    }

    /**
     * 服务中心--特色业务说明
     */
    @Story("服务中心首页--特色业务说明")
    @Test
    public void supportTsywconListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = SupportIndexPro.supportTsywconList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            getWindowsHandle();
        }
    }

}
