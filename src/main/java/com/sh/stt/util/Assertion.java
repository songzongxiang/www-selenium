package com.sh.stt.util;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Assert断言工具类
 */
public class Assertion {

    //为了使我们的Assert验证多条用例或者方法是否正确,
    //所以需要设定一个boolean值来进行判断识别,私有变量,防止外部访问
    public static boolean flag=true;
    public static List<Error> errors=new ArrayList<>();

    public static void verifyEquals(Object actual, Object expected){
        try{
            Assert.assertEquals(actual,expected);
        }catch(Error e){
            errors.add(e);
            //抛出异常时记录flag=false
            flag=false;
        }
    }

    /*
    添加static是为了在类刚加载的时候就能直接调用该类的静态方法
    Object参数类型是为了验证不同的数据类型,如String,int等
    */
    public static void verifyEquals(Object actual,Object expected,String message){
        /*
        添加try,catch是为了捕捉未封装前时如果验证失败后续用例无法执行报的错误
        使其能够跳过，继续执行后面的用例
        */
        /*
        注意:catch中的错误参数要是:Error类型的,有别于常见的Exception，
        这个是根据Assert未封装前验证两个值不同时抛出的 AssertionFailedError
        来涵盖此类型的所有错误父类,即Error
        */
        try{
            Assert.assertEquals(actual, expected, message);
        }catch(Error e){
            //仅仅代表异常消息的输出
            errors.add(e);
            //抛出异常时记录flag=false
            flag=false;
        }
    }

    public static void verifyNotEquals(Object actual, Object expected, String message){
        try{
            Assert.assertNotEquals(actual, expected, message);
        }catch(Error e){
            //仅仅代表异常消息的输出
            errors.add(e);
            //抛出异常时记录flag=false
            flag=false;
        }
    }

    public static void verifyFalse(Boolean condition, String message){
        try{
            Assert.assertFalse(condition, message);
        }catch(Error e){
            //仅仅代表异常消息的输出
            errors.add(e);
            //抛出异常时记录flag=false
            flag=false;
        }
    }

    public static void verifyTrue(Boolean condition, String message){
        try{
            Assert.assertTrue(condition, message);
        }catch(Error e){
            //仅仅代表异常消息的输出
            errors.add(e);
            //抛出异常时记录flag=false
            flag=false;
        }
    }

    public static void verifyNotNull(Object actual, String message){
        try{
            Assert.assertNotNull(actual, message);
        }catch(Error e){
            errors.add(e);
            flag=false;
        }
    }

    public static void verifyNull(Object actual, String message){
        try{
            Assert.assertNull(actual, message);
        }catch(Error e){
            errors.add(e);
            flag=false;
        }
    }

}
