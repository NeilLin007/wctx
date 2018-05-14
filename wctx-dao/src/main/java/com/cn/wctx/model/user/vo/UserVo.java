package com.cn.wctx.model.user.vo;

import org.jetbrains.annotations.NotNull;

/**
 * 用户信息参数
 *
 * @author
 * @create 2018-05-11 14:50
 **/
public class UserVo {
    @NotNull
    private String id;//用户id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
