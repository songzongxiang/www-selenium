package com.sh.stt.testCase.cishan;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.CiShanPagePro;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Feature("慈善基金会")
public class CiShan extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/cishan/indexc.html");
    }

    /**
     * 页头导航区
     */
    @Story("页头导航区")
    @Test
    public void headNavListTest() {
        //获取所有text的List集合
        List<String> listString = CiShanPagePro.headNavList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            back();
        }
    }

    /**
     * 友情链接
     */
    @Story("友情链接")
    @Test
    public void csLinkListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = CiShanPagePro.csLinkList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
            getWindowsHandle();
        }
    }

}
