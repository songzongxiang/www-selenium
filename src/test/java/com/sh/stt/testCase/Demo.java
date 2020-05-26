package com.sh.stt.testCase;

import com.sh.stt.base.BaseDriver;
import com.sh.stt.util.ScrollBarUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Demo extends BaseDriver {


    @BeforeMethod
    public void openURL() {
        driver.get("http://www.10086.cn/support/terminalapp/app/js/");
//        driver.get("http://www.10086.cn/support/service/channel/online/yn/");
    }

    @Test
    public void demoTest() throws InterruptedException {
        windowsHandle = driver.getWindowHandle(); //获取当前handle
//        WebElement element = driver.findElement(By.xpath(".//*[@id='main']/div[4]/ul/li[1]/a"));
        WebElement element = driver.findElement(By.xpath(".//*[@id='main']/div[4]/ul/li[1]/a"));
        ScrollBarUtil.scrolltoPresence(driver, element);
        element.click();
//        Thread.sleep(5000);
        getWindowsHandle();
//        Thread.sleep(5000);
    }

    @Test
    public void demoTest1() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(".//*[@id='r_3']/div[1]/ul/li[1]/dl[1]/dd/div/a/img"));
        ScrollBarUtil.scrolltoPresence(driver, element);
        element.click();
        Thread.sleep(2000);
        back();
        Thread.sleep(2000);
    }



//    public static void main(String[] args) {
//        List<String> expext_options = Arrays.asList((new String[]{"桃子","西瓜","橘子","猕猴桃","山楂","荔枝"}));
//
//        System.out.println("ints:" + expext_options.toString());//ints:[[I@5f4da5c3]
//    }

}
