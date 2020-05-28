package com.sh.stt.testCase.aboutus.gkml;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.aboutus.GkmlPagePro;
import com.sh.stt.page.aboutus.GkmlPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Feature("关于中国移动--信息公开--公开目录--企业业务发展")
public class NB extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/aboutus/xxgk/gkml/ywfz/nb/");
        driver.findElement(By.linkText("北京")).click();
    }

    /**
     * 年报
     */
    @Story("年报")
    @Test
    public void nbListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = GkmlPagePro.enterBusDevList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            getWindowsHandle();
        }
    }

    /**
     * 设备物资采购
     */
    @Story("设备物资采购")
    @Test
    public void equipmentMaterialListTest() {
        //判断元素是否存在
        if (BaseDriver.isElementExist(driver, GkmlPage.equipmentMaterial, 2)) {
            driver.findElement(GkmlPage.equipmentMaterial).click();
            //获取所有text的List集合
            List<String> listString = GkmlPagePro.equipmentMaterialList(driver);
            for (int i = 0; i < listString.size(); i++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[contains(text(),'" + listString.get(i) + "')]")));
                back();
            }
        }
    }

}
