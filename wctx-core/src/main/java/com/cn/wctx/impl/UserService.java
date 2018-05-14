package com.cn.wctx.impl;/**
 * Created by chuyoule on 2018/5/11.
 */

import com.cn.wctx.dao.user.UserDao;
import com.cn.wctx.model.user.User;
import com.cn.wctx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息service
 *
 * @author
 * @create 2018-05-11 14:59
 **/
@Service
public class UserService implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getDetail(String userId) {
        return userDao.getDetail(userId);
    }
}
