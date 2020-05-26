package com.sh.stt.page;

import org.openqa.selenium.By;

/**
 * 首页
 */
public class IndexPage {

    /**
     * 主广告区--轮播图--不包含标题(每天答一答流量等你拿)
     */
    public static By advCarList = By.xpath(".//*[@id='lbtframe']/div/a/img[not(contains(@title,'每天答一答流量等你拿'))]");

    /**
     * 快捷专区功能区--不包含(话费查询)
     */
    public static By quickList = By.xpath(".//*[@id='iconsA']/ul/li/a/img[not(contains(@alt,'话费查询'))]");

    /**
     * 左导航功能区
     */
    //左导航内容List
    public static By navListEle = By.xpath(".//*[@id='list235']/li/a");
    //办套餐dt内容List
    public static By businessdtContent = By.xpath(".//*[@id='nav235']/div[1]/div/dl/dt/a");
    //办套餐dd内容List
    public static By businessddContent = By.xpath(".//*[@id='nav235']/div[1]/div/dl/dd/a");
    //买手机dt内容List
    public static By mobiledtContent = By.xpath(".//*[@id='nav235']/div[2]/div/dl/dt/a");
    //买手机dd内容List
    public static By mobileddContent = By.xpath(".//*[@id='nav235']/div[2]/div/dl/dd/a");
    //套餐/靓号dt内容List
    public static By packagedtContent = By.xpath(".//*[@id='nav235']/div[3]/div/dl/dt/a");
    //套餐/靓号dd内容List
    public static By packageddContent = By.xpath(".//*[@id='nav235']/div[3]/div/dl/dd/a");
    //家庭业务dt内容List
    public static By familyBusdtContent = By.xpath(".//*[@id='nav235']/div[4]/div/dl/dt/a");
    //家庭业务dd内容List
    public static By familyBusddContent = By.xpath(".//*[@id='nav235']/div[4]/div/dl/dd/a");
    //智能硬件dt内容List
    public static By intelHarddtContent = By.xpath(".//*[@id='nav235']/div[5]/div/dl/dt/a");
    //智能硬件dd内容List
    public static By intelHardddContent = By.xpath(".//*[@id='nav235']/div[5]/div/dl/dd/a");
    //查询服务dt内容List
    public static By queryServicedtContent = By.xpath(".//*[@id='nav235']/div[6]/div/dl/dt/a");
    //查询服务dd内容List
    public static By queryServiceddContent = By.xpath(".//*[@id='nav235']/div[6]/div/dl/dd/a");
    //特色专区dt内容List
    public static By featuredtContent = By.xpath(".//*[@id='nav235']/div[7]/div/dl/dt/a");
    //特色专区dd内容List
    public static By featureddContent = By.xpath(".//*[@id='nav235']/div[7]/div/dl/dd/a");

    /**
     * 推荐营销位右侧轮播区
     */
    public static By yhgundongList = By.xpath(".//*[@id='yhgundong2']/div/a");

    /**
     * 1F 享优惠
     */
    public static By eventsListEle = By.xpath("//div[@id='louti1']/*/*/*/a");

    /**
     * 2F 业务推荐
     */
    public static By operateListEle = By.xpath("//div[@id='louti2']/*/*/*/a");


    /**
     * 3F 手机专区
     */
    //内容区List
    public static By mobileListEle = By.xpath("//div[@id='louti3']/*/*/*/a");

    /**
     * 4F 智能硬件
     */
    //内容区List
    public static By intelHardListEle = By.xpath("//div[@id='louti4']/*/*/*/a");

    /**
     * 6F 自定义楼层
     */
    //内容区List
    public static By customListEle = By.xpath("//div[@id='louti7']/*/*/*/a");


    /**
     * 定位特色专区按钮
     */
    public static By featureEle = By.xpath(".//*[@id='topHead']/div[14]/dl/dd/a/h4");

    /**
     * 定位公告按钮
     */
    public static By noticeEle = By.xpath(".//*[@id='topHead']/div[15]/ul/li/a");

    /**
     * 定位国资动态按钮
     */
    public static By gzdtEle = By.xpath(".//*[@id='topHead']/div[16]/ul/li/a");

    /**
     * 定位底部链接区按钮
     */
    public static By bottomEle = By.xpath(".//*[@id='bottom1200']/div/div/a");
}
