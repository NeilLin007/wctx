package com.cn.wctx.filter;/**
 * Created by chuyoule on 2018/5/10.
 */

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 跨域请求
 *
 * @author
 * @create 2018-05-10 15:09
 **/
public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String originParam = ((HttpServletRequest) servletRequest).getHeader("Origin");
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        if (PERMIT_ALLOW_ORIGIN.contains(originParam)) {
            res.setHeader("Access-Control-Allow-Origin", originParam);
        }
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with, Origin, Content-Type, Accept, Authorization");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    //允许跨越的域名，读写分离要用到
    public static final List<String> PERMIT_ALLOW_ORIGIN = Arrays.asList("aa", "bb");
}
