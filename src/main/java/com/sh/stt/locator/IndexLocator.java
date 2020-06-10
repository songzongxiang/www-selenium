package com.sh.stt.locator;

import org.openqa.selenium.By;

/**
 * 门户首页页面对象：元素定位
 */
public class IndexLocator {

    /**
     * 地市北京
     */
    public static final By BEIJING = By.linkText("北京");

    /**
     * 主广告区--轮播图List集合定位--不包含标题(每天答一答流量等你拿)
     */
    public static final By ADV_CAR_LIST = By.xpath(".//*[@id='lbtframe']/div/a/img[not(contains(@title,'每天答一答流量等你拿'))]");

    /**
     * 快捷专区功能区List集合定位--不包含(话费查询)
     */
    public static final By QUICK_LIST = By.xpath(".//*[@id='iconsA']/ul/li/a/img[not(contains(@alt,'话费查询'))]");

    /**
     * 左导航功能区
     */
    //左导航内容List集合定位
    public static final By LEFT_NAV_LIST = By.xpath(".//*[@id='list235']/li/a");
    //办套餐dt内容List集合定位
    public static final By BUSINESS_DT_CONTENT_LIST = By.xpath(".//*[@id='nav235']/div[1]/div/dl/dt/a");
    //办套餐dd内容List集合定位
    public static final By BUSINESS_DD_CONTENT_LIST = By.xpath(".//*[@id='nav235']/div[1]/div/dl/dd/a");
    //买手机dt内容List集合定位
    public static final By MOBILE_DT_CONTENT_LIST = By.xpath(".//*[@id='nav235']/div[2]/div/dl/dt/a");
    //买手机dd内容List集合定位
    public static final By MOBILE_DD_CONTENT_LIST = By.xpath(".//*[@id='nav235']/div[2]/div/dl/dd/a");
    //套餐/靓号dt内容List集合定位
    public static final By PACKAGE_DT_CONTENT_LIST = By.xpath(".//*[@id='nav235']/div[3]/div/dl/dt/a");
    //套餐/靓号dd内容List集合定位
    public static final By PACKAGE_DD_CONTENT_LIST = By.xpath(".//*[@id='nav235']/div[3]/div/dl/dd/a");
    //家庭业务dt内容List集合定位
    public static final By FAMILY_SERVICE_DT_CONTENT_LIST = By.xpath(".//*[@id='nav235']/div[4]/div/dl/dt/a");
    //家庭业务dd内容List集合定位
    public static final By FAMILY_SERVICE_DD_CONTENT_LIST = By.xpath(".//*[@id='nav235']/div[4]/div/dl/dd/a");
    //智能硬件dt内容List集合定位
    public static final By INTEL_HARD_DT_CONTENT_LIST = By.xpath(".//*[@id='nav235']/div[5]/div/dl/dt/a");
    //智能硬件dd内容List集合定位
    public static final By INTEL_HARD_DD_CONTENT_LIST = By.xpath(".//*[@id='nav235']/div[5]/div/dl/dd/a");
    //查询服务dt内容List集合定位
    public static final By QUERY_SERVICE_DT_CONTENT_LIST = By.xpath(".//*[@id='nav235']/div[6]/div/dl/dt/a");
    //查询服务dd内容List集合定位
    public static final By QUERY_SERVICE_DD_CONTENT_LIST = By.xpath(".//*[@id='nav235']/div[6]/div/dl/dd/a");
    //特色专区dt内容List集合定位
    public static final By FEATURE_DT_CONTENT_LIST = By.xpath(".//*[@id='nav235']/div[7]/div/dl/dt/a");
    //特色专区dd内容List集合定位
    public static final By FEATURE_DD_CONTENT_LIST = By.xpath(".//*[@id='nav235']/div[7]/div/dl/dd/a");

    /**
     * 推荐营销位右侧轮播区List集合定位
     */
    public static final By YH_GUNDONG_LIST = By.xpath(".//*[@id='yhgundong2']/div/a");

    /**
     * 1F 享优惠List集合定位
     */
    public static final By EVENTS_LIST = By.xpath("//div[@id='louti1']/*/*/*/a");

    /**
     * 2F 业务推荐List集合定位
     */
    public static final By OPERATE_LIST = By.xpath("//div[@id='louti2']/*/*/*/a");

    /**
     * 3F 手机专区List集合定位
     */
    public static final By MOBILE_LIST = By.xpath("//div[@id='louti3']/*/*/div[@id='fl_3_4' or @id='fl_3_5']/a");

    /**
     * 6F 自定义楼层List集合定位
     */
    public static final By CUSTOM_LIST = By.xpath("//div[@id='louti7']/*/*/*/a");

    /**
     * 底部链接区List集合定位
     */
    public static final By BOTTOM_LIST = By.xpath(".//*[@id='bottom1200']/div/div/a");

    /**
     * 右侧在线客服List集合定位
     */
    public static final By ONLINE_SERVICE_LIST = By.xpath(".//*[@id='topHead']/ul/li/a[starts-with(@class,'logo')]");
}
