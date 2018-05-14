package com.cn.wctx.service;

import com.cn.wctx.model.user.User;

/**
 * Created by chuyoule on 2018/5/11.
 */
public interface IUserService {
    /**
     * @description 获取用户信息
     * @author chuyoule 2018/5/11 15:00
     * @param userId 用户id
     * @return com.cn.wctx.model.user.User
    */
    User getDetail(String userId);
}
