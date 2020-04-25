package com.lagou.edu.controller;

import com.lagou.edu.dao.ResumeDao;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 研研
 * @date $(DATE)  $(TIME)
 */
@LagouController
@LagouRequestMapping("/resume")
public class ResumeController {
    private ResumeDao resumeDao;
    @RequestMapping("/del")
    @ResponseBody
    public void  delect(HttpServletRequest req, HttpServletResponse resp, HttpSecurity http) throws Exception {
        String id=req.getParameter("id");
        resumeDao.delect(id);
    }
    public void  add(HttpServletRequest req, HttpServletResponse resp, HttpSecurity http) throws Exception {
        String  id=req.getParameter("id");
        String username=req.getParameter("username");
        String adress=req.getParameter("adress");
        String phone=req.getParameter("phone");
        Map<String,String>  map= new HashMap<>();
        map.put("usernidame",username);
        map.put("id",id);
        map.put("adress",adress);
        map.put("phone",phone);
        resumeDao.add(map);
    }
    public void  edit(HttpServletRequest req, HttpServletResponse resp, HttpSecurity http) throws Exception {
        String  id=req.getParameter("id");
        String username=req.getParameter("username");
        String adress=req.getParameter("adress");
        String phone=req.getParameter("phone");
        Map<String,String>  map= new HashMap<>();
        map.put("usernidame",username);
        map.put("id",id);
        map.put("adress",adress);
        map.put("phone",phone);
        resumeDao.edit(map);
    }

}
