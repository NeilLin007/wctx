package com.cn.memory;/**
 * Created by chuyoule on 2018/5/26.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 测试堆内存溢出
 *
 * @author
 * @create 2018-05-26 17:44
 **/
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> oomObjectList=new ArrayList<>();
        while (true){
            oomObjectList.add(new OOMObject());
        }
    }
}
