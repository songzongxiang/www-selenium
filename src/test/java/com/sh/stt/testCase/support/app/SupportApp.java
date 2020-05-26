package com.sh.stt.testCase.support.app;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.support.SupportAppPagePro;
import com.sh.stt.page.support.SupportAppPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Feature("服务中心--终端应用--客户端下载")
public class SupportApp extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/support/terminalapp/app/bj/");
    }

    /**
     * 终端应用--客户端下载
     */
    @Story("终端应用--客户端下载")
    @Test
    public void supportAppListTest() {
        List<Integer> pageNumList = SupportAppPagePro.pageNumSupportAppNextButton(driver);
        for (int i = 0; i < pageNumList.size(); i++) {
            //获取所有text的List集合
            List<String> listString = SupportAppPagePro.supportAppList(driver);
            for (int j = 0; j < listString.size(); j++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(j)+"']")));
                back();
            }
            //判断元素是否存在
            if (BaseDriver.isElementExist(driver, SupportAppPage.supportAppNextEle, 2)) {
                //点击下一页
                driver.findElement(SupportAppPage.supportAppNextEle).click();
            }
        }
    }

}
