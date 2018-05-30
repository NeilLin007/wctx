package com.cn;/**
 * Created by chuyoule on 2018/5/26.
 */

/**
 * 方法区和运行时常量池
 *
 * @author
 * @create 2018-05-26 19:51
 **/
public class PermGenSpace {
    public static void main(String[] args) {
        String as="计算机软件";
        String str1 = new StringBuffer("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
