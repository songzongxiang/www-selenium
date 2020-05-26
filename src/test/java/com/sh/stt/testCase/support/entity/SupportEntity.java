package com.sh.stt.testCase.support.entity;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.support.SupportEntityPagePro;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Feature("服务中心--客户服务--实体营业厅")
public class SupportEntity extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/support/service/channel/entity/bj/");
    }

    /**
     * 客户服务--实体营业厅
     */
    @Story("客户服务--实体营业厅")
    @Test
    public void supportEntityListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = SupportEntityPagePro.supportEntityList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@khfw_styyt_map='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

}
