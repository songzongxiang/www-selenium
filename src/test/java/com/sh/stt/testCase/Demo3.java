package com.sh.stt.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo3 {
    WebDriver driver;
    public String windowsHandle;

    @BeforeMethod
    public void open() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
//        //实例化chromedriver
        driver = new ChromeDriver();

        driver.get("http://www.10086.cn/aboutus/news/pannounce/bj/index_100_100.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void DemoTest() throws InterruptedException {
//        Actions actions = new Actions(driver);
//        List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='louti5']/div/ul/li/a[1]/h4"));
//        List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='louti5']/div/ul/li/a[1]/h4"));
//        action(elements.get(1));
        
            windowsHandle = driver.getWindowHandle(); //获取当前handle
        List<String> pageNumList = pageNumList();
        for (int j = 0; j < pageNumList.size(); j++) {
            System.out.println("第" + (j + 1) + "页");
            //获取所有底部wtcode的List集合
//            List<String> bottomListString = bottomList();
//        for (int k = 0; k < bottomListString.size(); k++) {
//            // 点击底部wtcode为指定值的元素
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//*[contains(text(),'"+bottomListString.get(k)+"')]")));
//            this.getWindowsHandle();
////            Thread.sleep(2000);
//        }
//        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='pagination2']/ul[1]/li[4]/a")).click();
//            Thread.sleep(5000);

        }
    }


    /**
     * 获取所有底部链接区的List集合
     */
    public List<String> bottomList(){
        List<String> bottomList = new ArrayList<String>();
        //获取所有服务渠道列表
//        WebElement bottomLists = driver.findElement(By.id("bottom1200"));
        List<WebElement> bottomEleList = driver.findElements(By.xpath(".//*[@id='main']/div[3]/div/div/ul/li/span/a"));

        for (WebElement bottomEle:bottomEleList) {
            //获取底部wtcode
            String bottomWtcode = bottomEle.getText();
            System.out.println(bottomWtcode);
            bottomList.add(bottomWtcode);
        }
        return  bottomList;
    }

    public List<String> pageNumList() {
        // 定义一个List集合，用来保存pageNum
        List<String> pageNumList = new ArrayList<String>();
        // 获取底部页码a标签的集合
        List<WebElement> aEleList = driver.findElements(By.xpath(".//*[@id='pagination2']/ul[@class='pagination']/li/a[@trunmethod='+']/span"));
        //.//*[@id='louti5']/div/div/div/h4/span[2]/img
        for (WebElement aEle : aEleList) {
            String pageNum = aEle.getText();
            System.out.println(pageNum);
            pageNumList.add(pageNum);
//            if (isNumber(pageNum)) {
//                pageNumList.add(pageNum);
//            }

        }

        return pageNumList;
    }

//    public List<Integer> pageNumList() {
//        // 定义一个List集合，用来保存pageNum
//        List<Integer> pageNumList = new ArrayList<Integer>();
//        // 获取底部页码a标签的集合
//        List<WebElement> aEleList = driver.findElements(By.xpath(".//*[@id='pagination2']/ul[1]/li/a"));
//        for (WebElement aEle : aEleList) {
//            String pageNum = aEle.getText();
//            if (isNumber(pageNum)) {
//                pageNumList.add(Integer.parseInt(pageNum));
//                System.out.println(Integer.parseInt(pageNum));
//            }
//        }
//
//        return pageNumList;
//    }


    public boolean isNumber(String pageNum) {
        // 把正则表达式编译成模式对象
        Pattern p = Pattern.compile("[`»~]");
//        Pattern p = Pattern.compile("[0-9]*");
        // 通过模式对象得到匹配器对象，这个时候需要的是被匹配的字符串
        Matcher m = p.matcher(pageNum);
        // 调用匹配器对象的功能
        if (m.matches()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str="»";
        String regEx="[`»~]";
        Pattern p=Pattern.compile(regEx);
        Matcher m=p.matcher(str);
        System.out.println(m.find());
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

    public void action(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

}
