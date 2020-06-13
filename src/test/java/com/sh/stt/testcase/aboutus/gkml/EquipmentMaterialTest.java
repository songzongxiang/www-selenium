package com.sh.stt.testcase.aboutus.gkml;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.common.PageCommon;
import com.sh.stt.data.WWWData;
import com.sh.stt.locator.IndexLocator;
import com.sh.stt.page.aboutus.GkmlPage;
import com.sh.stt.locator.aboutus.GkmlLocator;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * 关于中国移动--信息公开--公开目录--设备物资采购 页面测试用例
 */
@Feature("关于中国移动--信息公开--公开目录--设备物资采购")
@Slf4j
public class EquipmentMaterialTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //页面操作方法
    public PageCommon pc;
    //公开目录页面对象
    public GkmlPage gkmlPage;

    @BeforeMethod
    public void beforeMethod() {
        bp = new BasePage(driver);
        pc = new PageCommon(driver);
        gkmlPage = new GkmlPage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.ABOUTUS_JDSJ_URL);
        if (pc.isElementExist(IndexLocator.BEIJING, 2)) {
            bp.findElement(IndexLocator.BEIJING).click();
        }
        log.info("进入 关于中国移动--信息公开--公开目录--设备物资采购 页面");
    }

    /**
     * 设备物资采购
     */
    @Story("设备物资采购")
    @Test
    public void equipmentMaterialListTest() {
        //判断元素是否存在
        if (pc.isElementExist(GkmlLocator.EQUIPMENT_MATERIAL_BUTTON, 2)) {
            bp.findElement(GkmlLocator.EQUIPMENT_MATERIAL_BUTTON).click();
            //获取所有text的List集合
            List<String> listString = gkmlPage.equipmentMaterialList();
            for (int i = 0; i < listString.size(); i++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//*[contains(text(),'" + listString.get(i) + "')]")));
                bp.back();
            }
        }
    }

}
