package com.sh.stt.testCase;

import com.sh.stt.base.BaseDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class testselenium {
    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test2(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void test3(){
        Assert.assertEquals("aaa","aaa");
    }

    @Test
    public void logDemo(){
        Reporter.log("测试报告中的打印日志");
        //抛出异常
        throw new RuntimeException("运行时抛出异常日志");
    }


}
