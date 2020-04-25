package com.lagou.demo.controller;

import com.lagou.demo.service.IDemoService;
import com.lagou.edu.mvcframework.annotations.LagouAutowired;
import com.lagou.edu.mvcframework.annotations.LagouController;
import com.lagou.edu.mvcframework.annotations.LagouRequestMapping;
import com.lagou.edu.mvcframework.annotations.Security;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@LagouController
@LagouRequestMapping("/demo")
public class DemoController {
    @LagouAutowired
    private IDemoService demoService;

    @LagouRequestMapping("/query")
    public String query(HttpServletRequest req, HttpServletResponse resp, String name){
        String s = demoService.get(name);
        return s;
    }



    // 方法上添加 @Security 注解，标明此处需要校验
    @Security(user_name = { "admin", "Administrator", "zhangsan" })
    @LagouRequestMapping("/userlogin01")
    public ModelAndView userlogin01(HttpServletRequest req, HttpServletResponse resp, HttpSecurity http, Authentication  authentication, String username) throws Exception {
        // 返回结果
        String message=null;
        ModelAndView modelAndView = new ModelAndView();
        RedirectStrategy  redirectStrategy=new DefaultRedirectStrategy();
        if(username != null){
            switch (username){
                case "admin":redirectStrategy.sendRedirect(req,resp,"/jsp/success");

                case "Administrator":redirectStrategy.sendRedirect(req,resp,"/jsp/success");
                case "zhangsan":redirectStrategy.sendRedirect(req,resp,"/jsp/success");
//                    System.out.println("成功，此用户 "+ username +" 通过校验");
//                    modelAndView.addObject("username",username);
//                    modelAndView.setViewName("success");

                    break;

                default:redirectStrategy.sendRedirect(req,resp,"/jsp/error");
                    System.out.println("失败，此用户 "+ username +" 没有访问权限");
                    message = "失败，此用户 "+ username +" 没有访问权限";
                    modelAndView.addObject("msg",message);
                    modelAndView.setViewName("error");
            }
        }else{
            message =  "失败，请输入访问的用户";
            System.out.println("失败，请输入访问的用户名");
            modelAndView.addObject("msg",message);
            modelAndView.setViewName("error");
        }
        return modelAndView;

    }

    @LagouRequestMapping("/userlogin02")
    @ResponseBody
//    public ModelAndView userlogin02(HttpServletRequest req, HttpServletResponse resp, String username){
//
//        System.out.println("用户username = "+username);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("username",username);
//        modelAndView.setViewName("success");
//        return modelAndView;
//    }
    public ModelAndView userlogin02(HttpServletRequest req, HttpServletResponse resp, String username){

        System.out.println("用户username = "+username);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username",username);
        modelAndView.setViewName("success");
        return modelAndView;
    }

}
