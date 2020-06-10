package com.sh.stt.testcase.support.serviceFee;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.common.PageCommon;
import com.sh.stt.data.WWWData;
import com.sh.stt.locator.IndexLocator;
import com.sh.stt.page.support.SupportServiceProductPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * 服务中心--业务资费--产品 页面测试用例
 */
@Feature("服务中心--业务资费--产品")
@Slf4j
public class SupportServiceProductTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //页面操作方法
    public PageCommon pc;
    //服务中心--业务资费--产品页面对象
    public SupportServiceProductPage supportServiceProductPage;

    @BeforeClass
    public void beforeClass() {
        bp = new BasePage(driver);
        pc = new PageCommon(driver);
        supportServiceProductPage = new SupportServiceProductPage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.SUPPORT_SERVICEFEE_PRODUCT_URL);
        if (pc.isElementExist(IndexLocator.BEIJING, 2)) {
            bp.findElement(IndexLocator.BEIJING).click();
        }
        log.info("进入 服务中心--业务资费--产品 页面");
    }

    /**
     * 业务资费--产品
     */
    @Story("业务资费--产品")
    @Test
    public void supportServiceProductListTest() {
        List<String> listString1 = supportServiceProductPage.supportServiceProductList();
        for (int i = 0; i < listString1.size(); i++) {
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@href='"+listString1.get(i)+"']")));
            //获取所有text的List集合
            List<String> listString2 = supportServiceProductPage.supportServiceProductDelList();
            for (int j = 0; j < listString2.size(); j++) {
                int count = Collections.frequency(listString2, listString2.get(j)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'"+listString2.get(j)+"')]")));
                bp.switchNextHandle();
            }
            bp.back();
        }
    }

}
