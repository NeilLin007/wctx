package com.cn.wctx.dao.user;

import com.cn.wctx.model.user.User;
import org.springframework.stereotype.Repository;

/**
 * Created by chuyoule on 2018/5/11.
 */
@Repository
public interface UserDao {
    User getDetail(String userId);
}
