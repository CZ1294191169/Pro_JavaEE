package com.cs.meet.controller;


import com.cs.meet.entity.User_info;
import com.cs.meet.services.servicesImpl.UserserImpl;
import com.cs.meet.util.HttpServletUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AjaxController {

    @Autowired
    UserserImpl userser;

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    //@ResponseBody
    public String check(@RequestParam("usercode") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {

        System.out.println(username);
        System.out.println(password);
        User_info user_info = new User_info();
        user_info.setUserCode(username);
        user_info.setLoginPassword(password);
        User_info token = userser.findByUserCode(username);
        if (token != null) {
            System.out.println(token.getUserName());

            System.out.println(token.getLoginPassword());
        }
        if (user_info == null) {
            System.out.println("user_info is null");
        }
        if (token != null) {
            System.out.println("token is not null");

            if (token.getUserCode().equals(user_info.getUserCode()) && token.getLoginPassword().equals(user_info.getLoginPassword())) {
                session.setAttribute("user", user_info);

                return "person";
            }
        } else {
            return "log";
        }
        return "log";

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        if (session != null) {
            User_info user = (User_info) session.getAttribute("user");//从当前session中获取用户信息
            session.invalidate();//关闭session
            return "log";
        }
        return "log";

    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    //@ResponseBody
    public String test(HttpServletRequest httpServletRequest) {
        //Map<String, Object> modelMap = new HashMap<String ,Object>();
        String userinfo = HttpServletUtil.getString(httpServletRequest, "user");
        ObjectMapper mapper = new ObjectMapper();
        User_info userInfo = null;
        try {
            userInfo = mapper.readValue(userinfo, User_info.class);
            System.out.println("userInfo" + userInfo.getUserCode() + "------>" + userInfo.getLoginPassword());
            User_info token = userser.findByUserCode(userInfo.getUserCode());
            if (token != null) {
                System.out.println("token" + token.getUserCode() + "------>" + token.getLoginPassword());
                System.out.println("!!!!");
                if (userInfo.getLoginPassword().equals(token.getLoginPassword())) {
                    System.out.println("???");
                    return "index";
                } else {
                    System.out.println("what???");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            //modelMap.put("success",false);
            //  modelMap.put("errMsg",e.getMessage());
            //e.printStackTrace();
            // return modelMap;
            System.out.println("again?");
            return "log";
        }
        return "log";

    }

}
