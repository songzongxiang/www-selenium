package com.sh.stt.page;

import org.openqa.selenium.By;

/**
 * 首页共有部分
 */
public class IndexCommonPage {

    /**
     * 页头
     */
    public static By headList = By.xpath("//*[@class='head_rg']/a");

    /**
     * 搜索
     */
    //搜索框
    public static By searchEle = By.id("skeywords");
    //搜索按钮
    public static By searchButtoon = By.id("searchbtn");
    //搜索热词
    public static By searchHot = By.xpath("//*[@class='hot hidden-sm']/a");

    /**
     * 4F 智能硬件
     */
    //内容区List
    public static By intelHardListEle = By.xpath("//div[@id='louti4']/*/*/*/a");

    /**
     * 5F 咪咕娱乐元素定位
     */
    //左导航List
    public static By miguListEle = By.xpath(".//*[@id='louti5']/div/ul/li/a[1]/h4");
    //右侧内容List
    public static By miguContentEle = By.xpath(".//*[@id='louti5']/div/div/div/div/dl/dd/a/h5");
    //咪咕音乐下一页按钮集合
    public static By miguMusicIconEle = By.xpath(".//*[@id='louti5']/div/div[1]/div/h4/span[2]/img");
    //咪咕音乐下一页按钮
    public static By miguMusicIcon = By.xpath(".//*[@id='louti5']/div/div[1]/div/h4/span[2]/img[2]");
    //咪咕游戏下一页按钮集合
    public static By miguGameIconEle = By.xpath(".//*[@id='louti5']/div/div[2]/div/h4/span[2]/img");
    //咪咕游戏下一页按钮
    public static By miguGameIcon = By.xpath(".//*[@id='louti5']/div/div[2]/div/h4/span[2]/img[2]");
    //咪咕阅读下一页按钮集合
    public static By miguReadIconEle = By.xpath(".//*[@id='louti5']/div/div[3]/div/h4/span[2]/img");
    //咪咕阅读下一页按钮
    public static By miguReadIcon = By.xpath(".//*[@id='louti5']/div/div[3]/div/h4/span[2]/img[2]");
    //咪咕圈圈下一页按钮集合
    public static By miguAnimeIconEle = By.xpath(".//*[@id='louti5']/div/div[4]/div/h4/span[2]/img");
    //咪咕圈圈下一页按钮
    public static By miguAnimeIcon = By.xpath(".//*[@id='louti5']/div/div[4]/div/h4/span[2]/img[2]");
    //焦点图内容List
    public static By miguBannerEle = By.xpath(".//*[@id='slideBox']/div[2]/ul/li/a/img");
    //流行乐风向标内容List
    public static By miguAlbumContentEle = By.xpath(".//*[@id='louti5']/div/div[5]/div[2]/div/div/a/img");
    //右侧热词List
    public static By miguHotWordEle = By.xpath(".//*[@id='louti5']/h3/ul/li/a");

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
     * 页脚
     */
    //带target
    public static By footerTargetList = By.xpath(".//*[@id='bj_tail']/section/div/a[starts-with(@target,'_blank')]");
    //不带target--不包含打击传销/营业厅/中国移动客户端下载
    public static By footerNotTargetList = By.xpath(".//*[@id='bj_tail']/section/div/a[not(starts-with(@target,'_blank')) and not(contains(@href,'djcx')) and not(contains(@onclick,'INDEX_FOOT_YYT')) and not(contains(@onclick,'INDEX_FOOT_APP'))]");
    //打击传销
    public static By DJCXButton = By.xpath(".//*[@id='bj_tail']/section/div[1]/a[12]/span");
    //营业厅
    public static By YYTButton = By.xpath(".//*[@id='bj_tail']/section/div[2]/a[3]");
    //中国移动客户端下载
    public static By APPButton = By.xpath(".//*[@id='bj_tail']/section/div[2]/a[4]");
    //可信网站
    public static By KXWZButton = By.xpath(".//*[@id='urlknet']/img");
    //京ICP备05002571号
    public static By govButton = By.xpath(".//*[@id='bj_tail']/section/div[5]/div[2]/p/a");

}
