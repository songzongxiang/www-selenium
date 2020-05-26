package com.sh.stt.testCase.kdzq;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.KDZQPagePro;
import com.sh.stt.page.KDZQPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Feature("云南宽带专区")
public class YNKdzq extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/kdzq/yn/index_871_871.html");
    }

    /**
     * 宽带专区--优质产品
     */
    @Story("宽带专区--优质产品")
    @Test
    public void broadbandProductTest() throws InterruptedException {
        //获取所有text的List集合
        List<String> listString = KDZQPagePro.broadbandProduct(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.findElement(By.xpath(".//*[@id='main']/div[6]/a[@wtcode='" + listString.get(i) + "']")).click();
            back();
        }
    }

    /**
     * 宽带专区--宽带服务
     */
    @Story("宽带专区--宽带服务")
    @Test
    public void broadbandServiceTest() {
        //获取所有text的List集合
        List<String> listString = KDZQPagePro.broadbandService(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            back();
        }
    }

    /**
     * 宽带专区--宽带产品列表
     */
    @Story("宽带专区--宽带产品列表")
    @Test
    public void broadbandProductListTest() {
        if (isElementExist(driver, KDZQPage.broadbandProductMore, 2)){
            driver.findElement(KDZQPage.broadbandProductMore).click();
            windowsHandle = driver.getWindowHandle(); //获取当前handle
            //获取所有text的List集合
            List<String> listString = KDZQPagePro.broadbandProductList(driver);
            for (int i = 0; i < listString.size() ; i++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//p[@title='"+listString.get(i)+"']")));
                getWindowsHandle();
            }
        }
    }

}
