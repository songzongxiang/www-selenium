package com.sh.stt.util;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.Reporter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 截图工具方法
 */
public class ScreenShot {

    @Attachment(value = "失败截图如下：",type = "image/png")
    public static byte[]  takePhoto(WebDriver driver){
        byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        return screenshotAs;
    }
}
