package com.sh.stt.testCase.webNotice;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.WebNoticePagePro;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Feature("网站信息--友情链接")
public class Links extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/web_notice/links/");
        driver.findElement(By.linkText("北京")).click();
    }

    /**
     * 网站信息--友情链接
     */
    @Story("网站信息--友情链接")
    @Test
    public void linksListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = WebNoticePagePro.linksList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

}
