package com.sh.stt.locator;

import org.openqa.selenium.By;

/**
 * 门户首页公共部分页面对象：元素定位
 */
public class IndexCommonLocator {

    /**
     * 页头List集合定位
     */
    public static final By HEAD_LIST = By.xpath("//*[@class='head_rg']/a");

    /**
     * 搜索
     */
    //搜索框定位
    public static final By SEARCH_INPUT = By.id("skeywords");
    //搜索按钮定位
    public static final By SEARCH_BUTTON = By.id("searchbtn");
    //搜索热词List集合定位
    public static final By SEARCH_HOT_LIST = By.xpath("//*[@class='hot hidden-sm']/a");

    /**
     * 4F 智能硬件
     */
    public static final By INTEL_HARD_LIST = By.xpath("//div[@id='louti4']/*/*/*/a");

    /**
     * 5F 咪咕娱乐元素定位
     */
    //焦点图内容List集合定位
    public static final By MIGU_BANNER_LIST = By.xpath(".//*[@id='slideBox']/div[2]/ul/li/a/img");
    //流行乐风向标内容List集合定位
    public static final By MIGU_ALBUM_CONTENT_LIST = By.xpath(".//*[@id='louti5']/div/div[5]/div[2]/div/div/a/img");
    //右侧热词List集合定位
    public static final By MIGU_HOT_LIST = By.xpath(".//*[@id='louti5']/h3/ul/li/a");

    /**
     * 特色专区List集合定位
     */
    public static final By FEATURE_LIST = By.xpath(".//*[@id='topHead']/div[14]/dl/dd/a/h4");

    /**
     * 公告List集合定位
     */
    public static final By NOTICE_LIST = By.xpath(".//*[@id='topHead']/div[15]/ul/li/a");

    /**
     * 国资动态List集合定位
     */
    public static final By GZDT_LIST = By.xpath(".//*[@id='topHead']/div[16]/ul/li/a");

    /**
     * 页脚
     */
    //带targetList集合定位
    public static final By FOOTER_TARGET_LIST = By.xpath(".//*[@id='bj_tail']/section/div/a[starts-with(@target,'_blank')]");
    //不带targetList集合定位--不包含打击传销/营业厅/中国移动客户端下载
    public static final By FOOTER_NOT_TARGET_LIST = By.xpath(".//*[@id='bj_tail']/section/div/a[not(starts-with(@target,'_blank')) and not(contains(@href,'djcx')) and not(contains(@onclick,'INDEX_FOOT_YYT')) and not(contains(@onclick,'INDEX_FOOT_APP'))]");
    //打击传销按钮定位
    public static final By DJCX_BUTTON = By.xpath(".//*[@id='bj_tail']/section/div[1]/a[12]/span");
    //营业厅按钮定位
    public static final By YYT_BUTTON = By.xpath(".//*[@id='bj_tail']/section/div[2]/a[3]");
    //中国移动客户端下载按钮定位
    public static final By APP_BUTTON = By.xpath(".//*[@id='bj_tail']/section/div[2]/a[4]");
    //可信网站按钮定位
    public static final By KXWZ_BUTTON = By.xpath(".//*[@id='urlknet']/img");
    //京ICP备05002571号按钮定位
    public static final By GOV_BUTTON = By.xpath(".//*[@id='bj_tail']/section/div[5]/div[2]/p/a");

}
