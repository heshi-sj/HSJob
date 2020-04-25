package com.lagou.edu.controller;


import com.lagou.edu.dao.ResumeDao;
import com.lagou.edu.pojo.Resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
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

public class LoginController {

    /**
     * Spring容器和SpringMVC容器是有层次的（父子容器）
     * Spring容器：service对象+dao对象
     * SpringMVC容器：controller对象，，，，可以引用到Spring容器中的对象
     */
private Resume resume;
    private ResumeDao resumeDao;
    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }
    /userlogin01
    @LagouRequestMapping("/login")
    @ResponseBody
    public void userlogin01(HttpServletRequest req, HttpServletResponse resp, HttpSecurity http, Authentication authentication, String username,String password) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        RedirectStrategy  redirectStrategy=new DefaultRedirectStrategy();
        if ((username=="adamin")&&(password=="adamin")){

            redirectStrategy.sendRedirect(req,resp,"/jsp/success");




         modelAndView.setViewName("success");


        }else {redirectStrategy.sendRedirect(req,resp,"/jsp/logon");
            modelAndView.setViewName("login");}
    }


    /*@RequestMapping("/queryAll")
    @ResponseBody
    public List<Account>  queryAll() throws Exception {
        return accountService.queryAccountList();
    }
    @RequestMapping("/del")
    @ResponseBody
    public void  delect(String  name) throws Exception {

    }
    @RequestMapping("/edit")
    @ResponseBody
    public void  edit() throws Exception {

    }*/


    }
