package com.cs.meet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
//    @RequestMapping({"/index"})
//    public String toindex()
//    {
//        return "log";
//    }

    @RequestMapping("/login")
    public String tolog()
    {
        return "log";
    }

    @RequestMapping("/app")
    public String tomeet()
    {
        return "tabel";
    }

    @RequestMapping("/cal")
    public String tocal()
    {
        return "calender";
    }

    @RequestMapping("/admin")
    public String admin(){return "adminplus";}

    @RequestMapping("/man")
    public String management(){return "usermangement";}

    @RequestMapping("/chart")
    public String chart(){return "Chart";}

    @RequestMapping("/admins")
    public String admins(){return "admins";}

    @RequestMapping("/person")
    public String person(){return "person";}

    @RequestMapping("b")
    public String broadcast(){return "broadcast";}

//    @RequestMapping("/nasus")
//    public String getView(){
//        return "nasus";
//    }
    @RequestMapping("/t")
    public String getView(){
        return "testWeb";
    }

//    @RequestMapping("/test")
//    public String totest()
//    {
//        return "test";
//    }


//    @RequestMapping("/check")
//    public Object check(@RequestParam String objectuser)
//    {
//return null;
//    }

}
