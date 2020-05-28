package com.sh.stt.testCase.index;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.IndexPagePro;
import com.sh.stt.page.IndexPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Feature("福建首页")
public class FJIndex extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/index/fj/index_591_591.html");
    }

    /**
     * 主广告区--轮播图
     */
    @Story("主广告区--轮播图")
    @Test
    public void advCarListTest() {
        //获取所有text的List集合
        List<String> listString = IndexPagePro.advCarList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//img[@title='"+listString.get(i)+"']")));
            back();
        }
    }

    /**
     * 快捷专区功能区
     */
    @Story("快捷专区功能区")
    @Test
    public void quickListTest() {
        //获取所有text的List集合
        List<String> listString = IndexPagePro.quickList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//img[@alt='"+listString.get(i)+"']")));
            back();
        }
    }

    /**
     * 左导航--办业务
     */
    @Story("左导航--办业务")
    @Test
    public void businessDtddTest() {
        List<WebElement> elements = driver.findElements(IndexPage.navListEle);
        action(elements.get(0));
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有wtcode的List集合
        List<String> listString = IndexPagePro.businessDddtList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 左导航--买手机
     */
    @Story("左导航--买手机")
    @Test
    public void mobileDtddTest() {
        List<WebElement> elements = driver.findElements(IndexPage.navListEle);
        action(elements.get(1));
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有wtcode的List集合
        List<String> listString = IndexPagePro.mobileDddtList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 左导航--套餐/靓号
     */
    @Story("左导航--套餐/靓号")
    @Test
    public void packageDtddTest() {
        List<WebElement> elements = driver.findElements(IndexPage.navListEle);
        action(elements.get(2));
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有wtcode的List集合
        List<String> listString = IndexPagePro.packageDddtList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 左导航--家庭业务
     */
    @Story("左导航--家庭业务")
    @Test
    public void familyBusDtddTest() {
        List<WebElement> elements = driver.findElements(IndexPage.navListEle);
        action(elements.get(3));
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有wtcode的List集合
        List<String> listString = IndexPagePro.familyBusDddtList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 左导航--智能硬件
     */
    @Story("左导航--智能硬件")
    @Test
    public void intelHardDtddTest() {
        List<WebElement> elements = driver.findElements(IndexPage.navListEle);
        action(elements.get(4));
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有wtcode的List集合
        List<String> listString = IndexPagePro.intelHardDddtList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 左导航--查询服务
     */
    @Story("左导航--查询服务")
    @Test
    public void queryServiceDtddTest() {
        List<WebElement> elements = driver.findElements(IndexPage.navListEle);
        action(elements.get(5));
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有wtcode的List集合
        List<String> listString = IndexPagePro.queryServiceDddtList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 左导航--特色专区
     */
    @Story("左导航--特色专区")
    @Test
    public void featureDtddTest() {
        List<WebElement> elements = driver.findElements(IndexPage.navListEle);
        action(elements.get(6));
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有wtcode的List集合
        List<String> listString = IndexPagePro.featureDddtList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 推荐营销位右侧轮播区
     */
    @Story("推荐营销位右侧轮播区")
    @Test
    public void yhgundongListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有wtcode的List集合
        List<String> listString = IndexPagePro.yhgundongList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 1F 享优惠-内容区
     */
    @Story("1F 享优惠-内容区")
    @Test
    public void eventsListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有wtcode的List集合
        List<String> listString = IndexPagePro.eventsList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 2F 业务推荐-内容区
     */
    @Story("2F 业务推荐-内容区")
    @Test
    public void operateListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有wtcode的List集合
        List<String> listString = IndexPagePro.operateList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 3F 手机专区-内容区
     */
    @Story("3F 手机专区-内容区")
    @Test
    public void mobileListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有wtcode的List集合
        List<String> listString = IndexPagePro.mobileList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            getWindowsHandle();
        }
    }

    /**
     * 底部链接区
     */
    @Story("底部链接区")
    @Test
    public void bottomListTest(){
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有底部wtcode的List集合
        List<String> listString = IndexPagePro.bottomList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            // 点击底部wtcode为指定值的元素
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 右侧在线客服
     */
    @Story("右侧在线客服")
    @Test
    public void onlineServiceListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有wtcode的List集合
        List<String> listString = IndexPagePro.onlineServiceList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

}
