package com.sh.stt.testcase.webNotice;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.common.PageCommon;
import com.sh.stt.data.WWWData;
import com.sh.stt.locator.IndexLocator;
import com.sh.stt.page.WebNoticePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * 网站信息--联系我们 页面测试用例
 */
@Feature("网站信息--联系我们")
@Slf4j
public class ContactTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //页面操作方法
    public PageCommon pc;
    //网站信息页面对象
    public WebNoticePage webNoticePage;

    @BeforeMethod
    public void beforeMethod() {
        bp = new BasePage(driver);
        pc = new PageCommon(driver);
        webNoticePage = new WebNoticePage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.WEBNOTICE_CONTACT_URL);
        if (pc.isElementExist(IndexLocator.BEIJING, 2)) {
            bp.findElement(IndexLocator.BEIJING).click();
        }
        log.info("进入 网站信息--联系我们 页面");
    }

    /**
     * 网站信息--联系我们
     */
    @Story("网站信息--联系我们")
    @Test
    public void contactListTest() {
        //获取所有text的List集合
        List<String> listString = webNoticePage.contactList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.switchNextHandle();
        }
    }
}
