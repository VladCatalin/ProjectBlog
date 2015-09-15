package com.service;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


/**
 * Created by CataVlad on 15-Sep-15.
 */
public class CorsFilter implements Filter {

    public void destroy() {
        // TODO Auto-generated method stub

    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        httpServletResponse.addHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.addHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE, PUT");
        httpServletResponse.addHeader("Access-Control-Max-Age","3600");
        httpServletResponse.addHeader("Access-Control-Allow-Headers","x-requested-with, X-Auth-Token, Content-Type");

        filterChain.doFilter(request, response);
    }



    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }
}
