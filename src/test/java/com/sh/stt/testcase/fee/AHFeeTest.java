package com.sh.stt.testcase.fee;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.common.PageCommon;
import com.sh.stt.data.WWWData;
import com.sh.stt.page.FeePage;
import com.sh.stt.locator.FeeLocator;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * 安徽资费专区 页面测试用例
 */
@Feature("安徽资费专区首页")
@Slf4j
public class AHFeeTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //页面操作方法
    public PageCommon pc;
    //资费专区页面对象
    public FeePage feePage;

    @BeforeMethod
    public void beforeMethod() {
        bp = new BasePage(driver);
        pc = new PageCommon(driver);
        feePage = new FeePage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.AH_FEE_URL);
        log.info("进入 安徽资费专区 页面");
    }

    /**
     * 资费专区--基础套餐/可选包内容
     */
    @Story("资费专区--基础套餐/可选包内容")
    @Test
    public void feeContentListTest() {
        if (pc.isElementExist(FeeLocator.FEE_MORE_BUTTON, 2)) {
            bp.findElement(FeeLocator.FEE_MORE_BUTTON).click();
            //获取所有text的List集合
            List<String> listString = feePage.feeContentList();
            for (int i = 0; i < listString.size(); i++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='" + listString.get(i) + "']")));
                bp.switchNextHandle();
            }
        }
    }

}
