package com.cn.wctx.model.user.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 用户信息参数
 *
 * @author
 * @create 2018-05-11 14:50
 **/
public class UserVo {
    @NotNull(message = "id 不为空")
    private String id;//用户id
    @Size(max = 20,min = 10,message = "姓名长度在10到20之间")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
