package com.cn.wctx.interceptor;/**
 * Created by chuyoule on 2018/5/10.
 */

import com.alibaba.fastjson.JSON;

import com.cn.wctx.constant.CoreR;
import com.cn.wctx.model.Resp;
import com.cn.wctx.util.JedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * session过滤
 *
 * @author
 * @create 2018-05-10 16:38
 **/
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    JedisService jedisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String accessToken = request.getParameter(CoreR.ACCESS_TOKEN);
        if (StringUtils.isEmpty(accessToken)) {
            return printError(request, response, "No Auth");
        }

        if (StringUtils.isEmpty(jedisService.get(accessToken))) {
            return printError(request, response, "No Login");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    /**
     * 打印错误信息
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    private boolean printError(HttpServletRequest request, HttpServletResponse response, String message)
            throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(new Resp(-1, message)));
        out.close();
        return false;
    }
}
