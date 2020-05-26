package com.sh.stt.testCase.headFooter;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.business.HeadFooterPagePro;
import com.sh.stt.business.HeadFooterPagePro;
import com.sh.stt.page.HeadFooterPage;
import com.sh.stt.page.HeadFooterPage;
import com.sh.stt.util.Assertion;
import com.sh.stt.util.ScrollBarUtil;
import io.qameta.allure.Story;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Feature("首页页头页脚咪咕娱乐在线客服")
public class HeadFooter extends BaseDriver {

    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/index/bj/index_100_100.html");
    }

    /**
     * 页头
     */
    @Story("页头")
    @Test
    public void headListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = HeadFooterPagePro.headList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            back();
        }
    }

    /**
     * 搜索关键字
     */
    @Story("搜索关键字")
    @Test
    public void searchKeyWordTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        WebElement keyWordEle = driver.findElement(HeadFooterPage.searchEle);
        keyWordEle.clear();
        keyWordEle.sendKeys("5G");
        driver.findElement(HeadFooterPage.searchButtoon).click();
        Set<String> handles = driver.getWindowHandles();
        for (String handle:handles){
            if (handle.equals(windowsHandle)){ //如果为 最先的窗口 权柄跳出
                continue;
            }
            driver.switchTo().window(handle); //如果不为最先的窗口权柄，将新窗口的操作权柄给driver
            Assertion.verifyEquals(driver.getTitle(), "5G_网页搜索_中国移动", "跟期望标题不一致" + "，当前URL:" + driver.getCurrentUrl());
            driver.close(); //关闭新弹出的浏览器窗口
            driver.switchTo().window(windowsHandle); //回到原始的浏览器窗口
        }
    }

    /**
     * 搜索热词
     */
    @Story("搜索热词")
    @Test
    public void searchHotListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = HeadFooterPagePro.searchHotList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
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
        List<String> listString = HeadFooterPagePro.onlineServiceList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 5F 咪咕娱乐-咪咕音乐
     */
    @Story("5F 咪咕娱乐-咪咕音乐")
    @Test
    public void miguMusicTest() {
        List<WebElement> elements = driver.findElements(HeadFooterPage.miguListEle);
        action(elements.get(0));
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        List<String> pageNumList = HeadFooterPagePro.pageNumMiguMusic(driver);
        for (int i = 0; i < pageNumList.size(); i++) {
            System.out.println("第" + (i + 1) + "页");
            //获取所有text的List集合
            List<String> listString = HeadFooterPagePro.miguList(driver);
            for (int j = 0; j < listString.size(); j++) {
                int count = Collections.frequency(listString, listString.get(j)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(j)+"')]")));
                getWindowsHandle();
            }
            driver.findElement(HeadFooterPage.miguMusicIcon).click();
        }
    }

    /**
     * 5F 咪咕娱乐-咪咕游戏
     */
    @Story("5F 咪咕娱乐-咪咕游戏")
    @Test
    public void miguGameTest() {
        List<WebElement> elements = driver.findElements(HeadFooterPage.miguListEle);
        action(elements.get(1));
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        List<String> pageNumList = HeadFooterPagePro.pageNumMiguGame(driver);
        for (int i = 0; i < pageNumList.size(); i++) {
            System.out.println("第" + (i + 1) + "页");
            //获取所有text的List集合
            List<String> listString = HeadFooterPagePro.miguList(driver);
            for (int j = 0; j < listString.size(); j++) {
                int count = Collections.frequency(listString, listString.get(j)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(j)+"')]")));
                getWindowsHandle();
            }
            driver.findElement(HeadFooterPage.miguGameIcon).click();
        }
    }

    /**
     * 5F 咪咕娱乐-咪咕阅读
     */
    @Story("5F 咪咕娱乐-咪咕阅读")
    @Test
    public void miguReadTest() {
        List<WebElement> elements = driver.findElements(HeadFooterPage.miguListEle);
        action(elements.get(2));
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        List<String> pageNumList = HeadFooterPagePro.pageNumMiguRead(driver);
        for (int i = 0; i < pageNumList.size(); i++) {
            //获取所有text的List集合
            List<String> listString = HeadFooterPagePro.miguList(driver);
            for (int j = 0; j < listString.size(); j++) {
                int count = Collections.frequency(listString, listString.get(j)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(j)+"')]")));
                getWindowsHandle();
            }
            driver.findElement(HeadFooterPage.miguReadIcon).click();
        }
    }

    /**
     * 5F 咪咕娱乐-咪咕圈圈
     */
    @Story("5F 咪咕娱乐-咪咕圈圈")
    @Test
    public void miguAnimeTest() {
        List<WebElement> elements = driver.findElements(HeadFooterPage.miguListEle);
        action(elements.get(3));
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        List<String> pageNumList = HeadFooterPagePro.pageNumMiguAnime(driver);
        for (int i = 0; i < pageNumList.size(); i++) {
            System.out.println("第" + (i + 1) + "页");
            //获取所有text的List集合
            List<String> listString = HeadFooterPagePro.miguList(driver);
            for (int j = 0; j < listString.size(); j++) {
                int count = Collections.frequency(listString, listString.get(j)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(j)+"')]")));
                getWindowsHandle();
            }
            driver.findElement(HeadFooterPage.miguAnimeIcon).click();
        }
    }

    /**
     * 5F 咪咕娱乐-焦点图
     */
    @Story("5F 咪咕娱乐-焦点图")
    @Test
    public void miguBannerTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有title的List集合
        List<String> listString = HeadFooterPagePro.miguBannerList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//img[@title='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 5F 咪咕娱乐-流行乐风向标
     */
    @Story("5F 咪咕娱乐-流行乐风向标")
    @Test
    public void miguAlbumTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有title的List集合
        List<String> listString = HeadFooterPagePro.miguAlbumList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//img[@title='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 5F 咪咕娱乐-热词
     */
    @Story("5F 咪咕娱乐-热词")
    @Test
    public void miguHotWordTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有wtcode的List集合
        List<String> listString = HeadFooterPagePro.miguHotWordList(driver);
        for (int i = 0; i < listString.size(); i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@wtcode='"+listString.get(i)+"']")));
            getWindowsHandle();
        }
    }

    /**
     * 页脚带target
     */
    @Story("页脚带target")
    @Test
    public void footerTargetListTest() {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = HeadFooterPagePro.footerTargetList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")));
            getWindowsHandle();
        }
    }

    /**
     * 页脚不带target
     */
    @Story("页脚不带target")
    @Test
    public void footerNotTargetListTest() throws InterruptedException {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有text的List集合
        List<String> listString = HeadFooterPagePro.footerNorTargetList(driver);
        for (int i = 0; i < listString.size() ; i++) {
            int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
            System.out.println("外链统计：" + count + "个");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[contains(text(),'"+listString.get(i)+"')]")));
            back();
        }
    }

    /**
     * 页脚底部
     */
    @Story("页脚底部")
    @Test
    public void footerBottomTest(){
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //打击传销
        WebElement DJCXEle = driver.findElement(HeadFooterPage.DJCXButton);
        ScrollBarUtil.scrolltoPresence(driver, DJCXEle);
        DJCXEle.click();
        back();
        //营业厅
        WebElement YYTEle = driver.findElement(HeadFooterPage.YYTButton);
        ScrollBarUtil.scrolltoPresence(driver, YYTEle);
        YYTEle.click();
        back();
        //中国移动客户端下载
        WebElement APPEle = driver.findElement(HeadFooterPage.APPButton);
        ScrollBarUtil.scrolltoPresence(driver, APPEle);
        APPEle.click();
        back();
        //可信网站
        WebElement KXWZEle = driver.findElement(HeadFooterPage.KXWZButton);
        ScrollBarUtil.scrolltoPresence(driver, KXWZEle);
        KXWZEle.click();
        getWindowsHandle();
        //京ICP备05002571号
        WebElement govEle = driver.findElement(HeadFooterPage.govButton);
        ScrollBarUtil.scrolltoPresence(driver, govEle);
        govEle.click();
        back();
    }

}
