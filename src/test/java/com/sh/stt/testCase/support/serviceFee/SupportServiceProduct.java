package com.sh.stt.testCase.support.serviceFee;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.support.SupportEventsPagePro;
import com.sh.stt.business.support.SupportServiceProductPro;
import com.sh.stt.page.support.SupportEventsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Feature("服务中心--业务资费--产品")
public class SupportServiceProduct extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/support/servicefee/newbusiness/");
        driver.findElement(By.linkText("北京")).click();
    }

    /**
     * 业务资费--产品
     */
    @Story("业务资费--产品")
    @Test
    public void supportServiceProductListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<String> listString1 = SupportServiceProductPro.supportServiceProductList(driver);
        for (int i = 0; i < listString1.size(); i++) {
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@href='"+listString1.get(i)+"']")));
            //获取所有text的List集合
            List<String> listString2 = SupportServiceProductPro.supportServiceProductDelList(driver);
            for (int j = 0; j < listString2.size(); j++) {
                int count = Collections.frequency(listString2, listString2.get(j)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString2.get(j)+"')]")));
                getWindowsHandle();
            }
            back();
        }
    }

}
