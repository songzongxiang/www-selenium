package com.sh.stt.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Demo2 {
    WebDriver driver;
    public String windowsHandle;

    @BeforeMethod
    public void open() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
//        //实例化chromedriver
        driver = new ChromeDriver();

        driver.get("http://www.10086.cn/index/bj/index_100_100.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void DemoTest(){
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有底部wtcode的List集合
        List<String> bottomListString = bottomList();
//        for (int i = 0; i < bottomListString.size() ; i++) {
//            // 点击底部wtcode为指定值的元素
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+bottomListString.get(i)+"')]")));
////            driver.findElement(By.xpath("//*[contains(text(),'" + bottomListString.get(i) + "')]")).click();
//            this.getWindowsHandle();
//
//        }

    }

    /**
     * 获取所有底部链接区的List集合
     */
    public List<String> bottomList(){
        List<String> bottomList = new ArrayList<String>();
        //获取所有服务渠道列表
//        WebElement bottomLists = driver.findElement(By.id("bottom1200"));
        List<WebElement> bottomEleList = driver.findElements(By.xpath("//*[@id='guesslike']/div/div/a/h4"));
        for (WebElement bottomEle:bottomEleList) {
            //获取底部wtcode
            String bottomWtcode = bottomEle.getText();
            System.out.println(bottomWtcode);
            bottomList.add(bottomWtcode);
        }
        return  bottomList;
    }

    public void getWindowsHandle(){
        Set<String> handles = driver.getWindowHandles();
        for (String s:handles){
            if (s.equals(windowsHandle)){
                continue;
            }
            System.out.println(s);
            driver.switchTo().window(s);
            driver.close(); //关闭新弹出的浏览器窗口
            driver.switchTo().window(windowsHandle); //回到原始的浏览器窗口
        }
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

}
