package com.sh.stt.testcase.support.entity;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.data.WWWData;
import com.sh.stt.page.support.SupportEntityPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * 服务中心--客户服务--实体营业厅 页面测试用例
 */
@Feature("服务中心--客户服务--实体营业厅")
@Slf4j
public class SupportEntityTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //服务中心--终端应用--客户端下载页面对象
    public SupportEntityPage supportEntityPage;

    @BeforeMethod
    public void beforeMethod() {
        bp = new BasePage(driver);
        supportEntityPage = new SupportEntityPage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.SUPPORT_ENTITY_URL);
        log.info("进入 服务中心--客户服务--实体营业厅 页面");
    }

    /**
     * 客户服务--实体营业厅
     */
    @Story("客户服务--实体营业厅")
    @Test
    public void supportEntityListTest() {
        //获取所有text的List集合
        List<String> listString = supportEntityPage.supportEntityList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@khfw_styyt_map='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

}
