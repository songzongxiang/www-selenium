package com.sh.stt.testcase.index;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.data.WWWData;
import com.sh.stt.page.IndexPage;
import com.sh.stt.locator.IndexLocator;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * 广西门户首页 页面测试用例
 */
@Feature("广西首页")
@Slf4j
public class GXIndexTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //首页页面对象
    public IndexPage indexPage;

    @BeforeClass
    public void beforeClass() {
        bp = new BasePage(driver);
        indexPage = new IndexPage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.GX_INDEX_URL);
        log.info("进入 广西门户首页 页面");
    }

    /**
     * 主广告区--轮播图
     */
    @Story("主广告区--轮播图")
    @Test
    public void advCarListTest() {
        log.info("主广告区");
        //获取所有text的List集合
        List<String> listString = indexPage.advCarList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//img[@title='"+listString.get(i)+"']")));
            bp.back();
        }
    }

    /**
     * 快捷专区功能区
     */
    @Story("快捷专区功能区")
    @Test
    public void quickListTest() {
        log.info("快捷专区功能区");
        //获取所有text的List集合
        List<String> listString = indexPage.quickList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//img[@alt='"+listString.get(i)+"']")));
            bp.back();
        }
    }

    /**
     * 左导航--办业务
     */
    @Story("左导航--办业务")
    @Test
    public void businessDtddTest() {
        log.info("左导航--办业务");
        List<WebElement> elements = bp.findElements(IndexLocator.LEFT_NAV_LIST);
        bp.moveToElement(elements.get(0));
        //获取所有wtcode的List集合
        List<String> listString = indexPage.businessDddtList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 左导航--买手机
     */
    @Story("左导航--买手机")
    @Test
    public void mobileDtddTest() {
        log.info("左导航--买手机");
        List<WebElement> elements = bp.findElements(IndexLocator.LEFT_NAV_LIST);
        bp.moveToElement(elements.get(1));
        //获取所有wtcode的List集合
        List<String> listString = indexPage.mobileDddtList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 左导航--套餐/靓号
     */
    @Story("左导航--套餐/靓号")
    @Test
    public void packageDtddTest() {
        log.info("左导航--套餐/靓号");
        List<WebElement> elements = bp.findElements(IndexLocator.LEFT_NAV_LIST);
        bp.moveToElement(elements.get(2));
        //获取所有wtcode的List集合
        List<String> listString = indexPage.packageDddtList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 左导航--家庭业务
     */
    @Story("左导航--家庭业务")
    @Test
    public void familyBusDtddTest() {
        log.info("左导航--家庭业务");
        List<WebElement> elements = bp.findElements(IndexLocator.LEFT_NAV_LIST);
        bp.moveToElement(elements.get(3));
        //获取所有wtcode的List集合
        List<String> listString = indexPage.familyServiceDddtList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 左导航--智能硬件
     */
    @Story("左导航--智能硬件")
    @Test
    public void intelHardDtddTest() {
        log.info("左导航--智能硬件");
        List<WebElement> elements = bp.findElements(IndexLocator.LEFT_NAV_LIST);
        bp.moveToElement(elements.get(4));
        //获取所有wtcode的List集合
        List<String> listString = indexPage.intelHardDddtList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 左导航--查询服务
     */
    @Story("左导航--查询服务")
    @Test
    public void queryServiceDtddTest() {
        log.info("左导航--查询服务");
        List<WebElement> elements = bp.findElements(IndexLocator.LEFT_NAV_LIST);
        bp.moveToElement(elements.get(5));
        //获取所有wtcode的List集合
        List<String> listString = indexPage.queryServiceDddtList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 左导航--特色专区
     */
    @Story("左导航--特色专区")
    @Test
    public void featureDtddTest() {
        log.info("左导航--特色专区");
        List<WebElement> elements = bp.findElements(IndexLocator.LEFT_NAV_LIST);
        bp.moveToElement(elements.get(6));
        //获取所有wtcode的List集合
        List<String> listString = indexPage.featureDddtList();
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 推荐营销位右侧轮播区
     */
    @Story("推荐营销位右侧轮播区")
    @Test
    public void yhgundongListTest() {
        log.info("推荐营销位右侧轮播区");
        //获取所有wtcode的List集合
        List<String> listString = indexPage.yhgundongList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 1F 享优惠-内容区
     */
    @Story("1F 享优惠-内容区")
    @Test
    public void eventsListTest() {
        log.info("1F 享优惠");
        //获取所有wtcode的List集合
        List<String> listString = indexPage.eventsList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 2F 业务推荐-内容区
     */
    @Story("2F 业务推荐-内容区")
    @Test
    public void operateListTest() {
        log.info("2F 业务推荐");
        //获取所有wtcode的List集合
        List<String> listString = indexPage.operateList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 3F 手机专区-内容区
     */
    @Story("3F 手机专区-内容区")
    @Test
    public void mobileListTest() {
        log.info("3F 手机专区");
        //获取所有wtcode的List集合
        List<String> listString = indexPage.mobileList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 底部链接区
     */
    @Story("底部链接区")
    @Test
    public void bottomListTest(){
        log.info("底部链接区");
        //获取所有底部wtcode的List集合
        List<String> listString = indexPage.bottomList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            // 点击底部wtcode为指定值的元素
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

    /**
     * 右侧在线客服
     */
    @Story("右侧在线客服")
    @Test
    public void onlineServiceListTest() {
        log.info("右侧在线客服");
        //获取所有wtcode的List集合
        List<String> listString = indexPage.onlineServiceList();
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            bp.switchNextHandle();
        }
    }

}
