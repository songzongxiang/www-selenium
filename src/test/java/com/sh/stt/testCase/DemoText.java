package com.sh.stt.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoText {
    public WebDriver driver;
    public String windowsHandle;

    @BeforeTest
    public void open() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
//        //实例化chromedriver
        driver = new ChromeDriver();

        driver.get("http://www.10086.cn/aboutus/news/groupnews/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        Thread.sleep(5000);
    }

    @Test
    public void DemoText() throws InterruptedException {
        driver.findElement(By.linkText("北京")).click();
//        Thread.sleep(5000);
        windowsHandle = driver.getWindowHandle(); //获取当前handle
        //获取所有底部wtcode的List集合
//        List<String> bottomListString = bottomList();
        // 获取底部页码的集合

        WebElement nextPage = driver.findElement(By.xpath("//ul[@class='pagination']/li/a[@trunmethod='+']"));
        while (nextPage.isDisplayed()){
            List<String> bottomListString = bottomList();
            for (int i = 0; i < bottomListString.size() ; i++) {
                // 点击底部wtcode为指定值的元素
                driver.findElement(By.xpath("//div[@class='listcon']/*/*/*/a[@href='" + bottomListString.get(i) + "']")).click();
                this.getWindowsHandle();

            }
        }

        nextPage.click();
        nextPage = driver.findElement(By.xpath("//ul[@class='pagination']/li/a[@trunmethod='+']"));

    }

    public List<String> bottomList(){
        List<String> bottomList = new ArrayList<String>();
        //获取所有服务渠道列表
//        WebElement bottomLists = driver.findElement(By.id("bottom1200"));
        List<WebElement> bottomEleList = driver.findElements(By.xpath("//div[@class='listcon']/*/*/*/a[contains(@href,'aboutus')]"));
        for (WebElement bottomEle:bottomEleList) {
            //获取底部wtcode
            String bottomWtcode = bottomEle.getAttribute("href");
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

    /**
     * 获取底部页码的集合
     */
    public List<Integer> pageNumList(){
        //定义一个List集合，用来保存pageNum
        List<Integer> pageNumList = new ArrayList<Integer>();
        //获取底部页码a标签的集合
        List<WebElement> aEleList = driver.findElement(By.id("pagination2")).findElements(By.xpath(".//ul[@class='pagination']/li/a"));
        for (WebElement aEle:aEleList) {
            String pageNum = aEle.getText();
            if (isNumber(pageNum)){
                pageNumList.add(Integer.parseInt(pageNum));
            }
        }
        return pageNumList;
    }


    /**
     * 判断pageNum是不是数字
     *
     * @param pageNum
     * @return
     */
    public boolean isNumber(String pageNum) {
        // 把正则表达式编译成模式对象
        Pattern p = Pattern.compile("[0-9]*");
        // 通过模式对象得到匹配器对象，这个时候需要的是被匹配的字符串
        Matcher m = p.matcher(pageNum);
        // 调用匹配器对象的功能
        if (m.matches()) {
            return true;
        }
        return false;
    }

    @AfterTest
    public void afterTest() {
        driver.close();// 关闭浏览器
    }

}
