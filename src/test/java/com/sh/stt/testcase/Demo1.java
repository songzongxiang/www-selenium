package com.sh.stt.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Demo1 {
    private static String currentWindow;
    public WebDriver driver;

    @BeforeTest
    public void open() throws InterruptedException {
        //设置chromedriver路径
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
//        //实例化chromedriver
        driver = new ChromeDriver();

        driver.get("http://www.10086.cn/aboutus/news/pannounce/ah/index_551_551.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//        Thread.sleep(5000);
    }

    @Test
    public void test() {
//        driver.findElement(By.linkText("北京")).click();

        WebElement nextPage=driver.findElement(By.xpath("//ul[@class='pagination']/li/a[@trunmethod='+']"));
        while(nextPage.isDisplayed())
        {

            List<WebElement> links=driver.findElements(By.xpath("//div[@class='listcon']/*/*/*/a[contains(@href,'aboutus')]"));

            for(WebElement link:links)
            {
                WebDriver window;
                System.out.println(link.getText());
                link.click();
                currentWindow = driver.getWindowHandle();
                //get all windows
                Set<String> handles= driver.getWindowHandles();
                for (String s : handles)
                {
                    //current page is don't close
                    if (s.equals(currentWindow))
                        continue;
                    else
                    {
                        window =driver.switchTo().window(s);
                        window.manage().window().maximize();
                        window.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                        window.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

                        //close the table window
                        window .close() ;
                    }
                    //swich to current window
                    driver.switchTo().window(currentWindow);
                }

            }
            // click next page
            nextPage.click();
            //set next page to current page
            driver=driver.switchTo().window(driver.getWindowHandle());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            nextPage=driver.findElement(By.xpath("//ul[@class='pagination']/li/a[@trunmethod='+']"));

        }


    }



}
