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

@Feature("网站信息--站点导航")
public class Navitation extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/web_notice/navigation/");
        driver.findElement(By.linkText("北京")).click();
    }

    /**
     * 网站信息--站点导航
     */
    @Story("网站信息--站点导航")
    @Test
    public void navigationListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = WebNoticePagePro.navigationList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

}
