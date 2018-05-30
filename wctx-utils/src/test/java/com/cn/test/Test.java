package com.cn.test;/**
 * Created by chuyoule on 2018/5/24.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 简单java测试
 *
 * @author
 * @create 2018-05-24 11:22
 **/
public class Test {

    @org.junit.Test
    public void TestGrok() {
        String aa = "\"Regex\"";
        Pattern pattern = Pattern.compile(".*");
        Matcher matcher = pattern.matcher(aa);
        if (matcher.find())
            System.out.println(matcher.group());

        pattern = Pattern.compile(".*?");
        matcher = pattern.matcher(aa);
        if (matcher.find())
            System.out.println(matcher.group());

    }

    @org.junit.Test
    public void testHashMap(){
        Map<String,String> map=new HashMap<>();
        map.put("aa","b");
       String re= map.putIfAbsent("aa","a");
        System.out.println(re);
        String aa=new String("aa");
        aa.intern();

    }


}
