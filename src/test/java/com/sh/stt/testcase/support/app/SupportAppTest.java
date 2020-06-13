package com.sh.stt.testcase.support.app;

import com.sh.stt.base.BaseTest;
import com.sh.stt.common.BasePage;
import com.sh.stt.common.PageCommon;
import com.sh.stt.data.WWWData;
import com.sh.stt.page.support.SupportAppPage;
import com.sh.stt.locator.support.SupportAppLocator;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * 服务中心--终端应用--客户端下载 页面测试用例
 */
@Feature("服务中心--终端应用--客户端下载")
@Slf4j
public class SupportAppTest extends BaseTest {

    //浏览器页面基类
    public BasePage bp;
    //页面操作方法
    public PageCommon pc;
    //服务中心--终端应用--客户端下载页面对象
    public SupportAppPage supportAppPage;

    @BeforeMethod
    public void beforeMethod() {
        bp = new BasePage(driver);
        pc = new PageCommon(driver);
        supportAppPage = new SupportAppPage(driver);
        bp.currentHandle = driver.getWindowHandle(); //获取当前handle
        bp.get(WWWData.SUPPORT_APP_URL);
        log.info("进入 服务中心--终端应用--客户端下载 页面");
    }

    /**
     * 终端应用--客户端下载
     */
    @Story("终端应用--客户端下载")
    @Test
    public void supportAppListTest() {
        List<Integer> pageNumList = supportAppPage.pageNumSupportAppNextButton();
        for (int i = 0; i < pageNumList.size(); i++) {
            //获取所有text的List集合
            List<String> listString = supportAppPage.supportAppList();
            for (int j = 0; j < listString.size(); j++) {
                int count = Collections.frequency(listString, listString.get(i)); //统计链接多少个
                System.out.println("外链统计：" + count + "个");
                bp.executeScript("arguments[0].click();", bp.findElement(By.xpath("//a[@wtcode='"+listString.get(j)+"']")));
                bp.back();
            }
            //判断元素是否存在
            if (pc.isElementExist(SupportAppLocator.SUPPORT_APP_NEXT_BUTTON, 2)) {
                //点击下一页
                bp.findElement(SupportAppLocator.SUPPORT_APP_NEXT_BUTTON).click();
            }
        }
    }

}
