package com.sh.stt.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Properties;

/**
 * 读取 properties 文件的工具类
 */
@Slf4j
public class PropertiesReader {
    /**
     * 配置文件
     */
    private static Properties properties = new Properties();

    /**
     * 读取 properties 测试项目配置文件
     *
     * @param propertiesPath 配置文件路径
     * @return Properties
     * @throws IOException IOException
     */
    public static Properties readProperties(String propertiesPath) throws IOException {
        log.info("读取项目配置文件");
        InputStream inputStream = new FileInputStream(propertiesPath);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        properties.load(bufferedReader);
        return properties;
    }

    /**
     * 依据键名获取配置文件中的键值
     *
     * @param key 键名
     * @return 键值
     */
    public static String getKey(String key) {
        return properties.getProperty(key);
    }
}
