package com.sh.stt.testcase.kdtsjf;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.data.WWWData;
import com.sh.stt.page.KDTSJFPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * 湖南宽带提速降费 页面测试用例
 */
@Feature("湖南宽带提速降费")
@Slf4j
public class HNKdtsjfTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //宽带提速降费页面对象
    public KDTSJFPage kdtsjfPage;

    @BeforeClass
    public void beforeClass() {
        bp = new BasePage(driver);
        kdtsjfPage = new KDTSJFPage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.HN_KDTSJF_URL);
        log.info("进入 湖南宽带提速降费 页面");
    }

    /**
     * 宽带提速降费--宽带新装
     */
    @Story("宽带提速降费--宽带新装")
    @Test
    public void broadbandNewClothesListTest() {
        log.info("宽带新装");
        //获取所有text的List集合
        List<String> listString = kdtsjfPage.broadbandNewClothesList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.switchNextHandle();
        }
    }

    /**
     * 宽带提速降费--宽带升级
     */
    @Story("宽带提速降费--宽带升级")
    @Test
    public void broadbandUpgradeListTest() {
        log.info("宽带升级");
        //获取所有text的List集合
        List<String> listString = kdtsjfPage.broadbandUpgradeList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            bp.switchNextHandle();
        }
    }

}
