package com.cn.wctx.controller;/**
 * Created by chuyoule on 2018/5/11.
 */

import com.alibaba.fastjson.JSON;

import com.cn.wctx.model.Resp;
import com.cn.wctx.model.user.User;
import com.cn.wctx.model.user.vo.UserVo;
import com.cn.wctx.service.IUserService;
import com.cn.wctx.util.JedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 用户信息controller
 *
 * @author
 * @create 2018-05-11 14:43
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    JedisService jedisService;

    Logger loggger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("common/getDetail")
    @ResponseBody
    public Resp getDetail(@RequestBody @Valid UserVo userVo, HttpServletRequest request) {
        loggger.info("日志測試-----------");
        User user = userService.getDetail(userVo.getId());
        jedisService.set(userVo.getId(), JSON.toJSONString(user));
        loggger.info("日志測試結束------");
        return Resp.showSuccess(user);
    }
}
