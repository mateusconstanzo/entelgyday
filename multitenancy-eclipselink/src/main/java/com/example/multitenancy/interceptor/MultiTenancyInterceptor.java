package com.example.multitenancy.interceptor;


import com.example.multitenancy.TenantHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultiTenancyInterceptor extends HandlerInterceptorAdapter {

    public static final String TENANT = "tenant-id";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  throws Exception {

        final String tenant = request.getHeader(TENANT);

        TenantHolder.setCurrentTenant(tenant);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        TenantHolder.clear();
    }

}
