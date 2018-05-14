package com.cn.wctx.model.base;/**
 * Created by chuyoule on 2018/5/11.
 */

import java.util.Date;

/**
 * 基础信息类
 *
 * @author
 * @create 2018-05-11 17:18
 **/
public class BaseEntity {
    private Date createTime;
    private Date updateTime;
    private String id;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
