package com.cn.wctx.test.thread;/**
 * Created by chuyoule on 2018/5/16.
 */

import com.alibaba.fastjson.JSON;

/**
 * 杂牌测试类
 *
 * @author
 * @create 2018-05-16 15:22
 **/
public class TestSimple {
    public static void main(String[] args) {
        Student student = new Student();
        if (student instanceof Person) {
            System.out.println(JSON.toJSONString(student));
        }
    }
}

class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

class Student extends Person {
    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
