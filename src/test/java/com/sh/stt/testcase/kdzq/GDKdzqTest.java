package com.sh.stt.testcase.kdzq;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.common.PageCommon;
import com.sh.stt.data.WWWData;
import com.sh.stt.page.KDZQPage;
import com.sh.stt.locator.KDZQLocator;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * 广东宽带专区 页面测试用例
 */
@Feature("广东宽带专区")
@Slf4j
public class GDKdzqTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //页面操作方法
    public PageCommon pc;
    //宽带提速降费页面对象
    public KDZQPage kdzqPage;

    @BeforeClass
    public void beforeClass() {
        bp = new BasePage(driver);
        pc = new PageCommon(driver);
        kdzqPage = new KDZQPage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.GD_KDZQ_URL);
        log.info("进入 广东宽带专区 页面");
    }

    /**
     * 宽带专区--优质产品
     */
    @Story("宽带专区--优质产品")
    @Test
    public void broadbandProductTest() throws InterruptedException {
        log.info("优质产品");
        //获取所有text的List集合
        List<String> listString = kdzqPage.broadbandProduct();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.findElement(By.xpath(".//*[@id='main']/div[6]/a[@wtcode='" + listString.get(i) + "']")).click();
            bp.back();
        }
    }

    /**
     * 宽带专区--宽带服务
     */
    @Story("宽带专区--宽带服务")
    @Test
    public void broadbandServiceTest() {
        log.info("宽带服务");
        //获取所有text的List集合
        List<String> listString = kdzqPage.broadbandService();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.back();
        }
    }

    /**
     * 宽带专区--宽带产品列表
     */
    @Story("宽带专区--宽带产品列表")
    @Test
    public void broadbandProductListTest() {
        log.info("宽带产品列表");
        if (pc.isElementExist(KDZQLocator.BROADBAND_PRODUCT_MORE_BUTTON, 2)){
            bp.findElement(KDZQLocator.BROADBAND_PRODUCT_MORE_BUTTON).click();
            //获取所有text的List集合
            List<String> listString = kdzqPage.broadbandProductList();
            for (int i = 0; i < listString.size() ; i++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//p[@title='"+listString.get(i)+"']")));
                bp.switchNextHandle();
            }
        }
    }

}
