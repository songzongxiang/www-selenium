package com.sh.stt.testCase.fiveG;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.FiveGPagePro;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Feature("浙江5G专区首页")
public class ZJFiveG extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/5G/zj/indexc.html");
    }

    /**
     * 快捷入口内容
     */
    @Story("快捷入口内容")
    @Test
    public void quickContentListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = FiveGPagePro.quickContentList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
            getWindowsHandle();
        }
    }

    /**
     * 5G套餐
     */
    @Story("5G套餐")
    @Test
    public void packageContentListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = FiveGPagePro.packageContentList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            getWindowsHandle();
        }
    }

    /**
     * 5G终端
     */
    @Story("5G终端--运营位")
    @Test
    public void phoneContentListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = FiveGPagePro.phoneContentList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
            getWindowsHandle();
        }
    }

    /**
     * 5G终端--轮播内容
     */
    @Story("5G终端--轮播内容")
    @Test
    public void phoneCarouselContentListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = FiveGPagePro.phoneCarouselContentList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
            getWindowsHandle();
        }
    }


}
