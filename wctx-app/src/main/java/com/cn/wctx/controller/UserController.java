package com.cn.wctx.controller;/**
 * Created by chuyoule on 2018/5/11.
 */

import com.cn.wctx.model.Resp;
import com.cn.wctx.model.user.User;
import com.cn.wctx.model.user.vo.UserVo;
import com.cn.wctx.service.IUserService;
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

    @RequestMapping("common/getDetail")
    @ResponseBody
    public Resp getDetail(@RequestBody @Valid UserVo userVo, HttpServletRequest request) {
        User user = userService.getDetail(userVo.getId());
        return Resp.showSuccess(user);
    }
}
