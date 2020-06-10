package com.sh.stt.testcase.fiveG;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.data.WWWData;
import com.sh.stt.page.FiveGPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * 吉林5G专区首页 页面测试用例
 */
@Feature("吉林5G专区首页")
@Slf4j
public class JLFiveGTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //5G专区页面对象
    public FiveGPage fiveGPage;

    @BeforeClass
    public void beforeClass() {
        bp = new BasePage(driver);
        fiveGPage = new FiveGPage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.JL_FIVEG_URL);
        log.info("进入 吉林5G专区首页 页面");
    }

    /**
     * 快捷入口内容
     */
    @Story("快捷入口内容")
    @Test
    public void quickContentListTest() {
        log.info("快捷入口");
        //获取所有text的List集合
        List<String> listString = fiveGPage.quickContentList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 5G套餐
     */
    @Story("5G套餐")
    @Test
    public void packageContentListTest() {
        log.info("5G套餐");
        //获取所有text的List集合
        List<String> listString = fiveGPage.packageContentList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.switchNextHandle();
        }
    }

    /**
     * 5G终端
     */
    @Story("5G终端--运营位")
    @Test
    public void phoneContentListTest() {
        log.info("5G终端--运营位");
        //获取所有text的List集合
        List<String> listString = fiveGPage.phoneContentList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 5G终端--轮播内容
     */
    @Story("5G终端--轮播内容")
    @Test
    public void phoneCarouselContentListTest() {
        log.info("5G终端--轮播内容");
        //获取所有text的List集合
        List<String> listString = fiveGPage.phoneCarouselContentList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@href='" + listString.get(i) + "']")));
            bp.switchNextHandle();
        }
    }

}
