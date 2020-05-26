package com.sh.stt.testCase.fee;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.FeePagePro;
import com.sh.stt.page.FeePage;
import com.sh.stt.util.ScrollBarUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Feature("北京资费专区")
public class BJFee extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/fee/bj/index_100_100.html");
    }

    /**
     * 资费专区--基础套餐/可选包内容
     */
    @Story("资费专区--基础套餐/可选包内容")
    @Test
    public void feeContentListTest() {
        //                    WebElement moreEle1 = driver.findElement(FeePage.feeMoreEle);
//        ScrollBarUtil.scrolltoPresence(driver, moreEle1);
//        moreEle1.click();
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = FeePagePro.feeContentList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

}
