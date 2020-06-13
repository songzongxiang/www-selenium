package com.sh.stt.testcase.cishan;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.data.WWWData;
import com.sh.stt.page.CiShanPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * 慈善基金会 页面测试用例
 */
@Feature("慈善基金会")
@Slf4j
public class CiShanTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //慈善基金会页面对象
    public CiShanPage ciShanPage;

    @BeforeMethod
    public void beforeMethod() {
        bp = new BasePage(driver);
        ciShanPage = new CiShanPage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.CISHAN_URL);
        log.info("进入 慈善基金会 页面");
    }

    /**
     * 页头导航区
     */
    @Story("页头导航区")
    @Test
    public void headNavListTest() {
        log.info("页头导航区");
        //获取所有text的List集合
        List<String> listString = ciShanPage.headNavList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.back();
        }
    }

    /**
     * 友情链接
     */
    @Story("友情链接")
    @Test
    public void csLinkListTest() {
        log.info("友情链接");
        //获取所有text的List集合
        List<String> listString = ciShanPage.csLinkList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
            bp.switchNextHandle();
        }
    }

}
