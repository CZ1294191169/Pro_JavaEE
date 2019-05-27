package com.cs.meet.controller;


import com.alibaba.fastjson.JSONObject;
import com.cs.meet.dto.*;
import com.cs.meet.entity.User_info;
import com.cs.meet.services.UserinfoServices;
import com.cs.meet.services.affairsServices;
import com.cs.meet.util.DateUtil;
import com.cs.meet.util.HttpServletUtil;
import com.cs.meet.util.WebSocket;
import com.cs.meet.util.convertUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.beans.Transient;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    affairsServices affairs;

    @Autowired
    UserinfoServices userinfoServices;

    @GetMapping("/appcheck")
    @ResponseBody
    public List<Affaircheckcondition> Appcheck(HttpServletRequest request,
                                               HttpSession session) throws Exception {

        List<Object[]> affaircheckconditions = affairs.affairchenck();

        List<Affaircheckcondition> list = convertUtil.castEntity(affaircheckconditions,Affaircheckcondition.class);

        return list;
    }

    @PostMapping("/delete")
    @ResponseBody
    @Transactional
    public Map<String,Object> deleteuser(HttpServletRequest request,@RequestBody JSONObject jsonObject) throws IOException {
        Map<String,Object> modelmap = new HashMap<>();


        User_info userInfo = userinfoServices.findByUserName(jsonObject.getString("userName"));

        try {
            userinfoServices.deleteById(userInfo.getUserId());
            modelmap.put("success",true);
        }catch (RuntimeException e){
            modelmap.put("success",false);
        }



        return modelmap;
    }


    @PostMapping("/update")
    @ResponseBody
    public Map<String,Object> UpdateStatus(HttpServletRequest request,HttpSession session) throws IOException {
        Map<String,Object> modelmap = new HashMap<>();

        String affirs = HttpServletUtil.getString(request,"status");

        ObjectMapper mapper = new ObjectMapper();

        Affstatuscondition affstatuscondition = null;

        affstatuscondition = mapper.readValue(affirs,Affstatuscondition.class);
        int effectrow = 0;
        try {
            if(affstatuscondition.getAffairsStatus()==1){ effectrow= affairs.updateAffairstatus(affstatuscondition.getAffairsId());}
            else if(affstatuscondition.getAffairsStatus()==-1){
                effectrow = affairs.ufailAffairstatus(affstatuscondition.getAffairsId());
            }
            if(effectrow>0)
            modelmap.put("success",true);
            else
            {
                modelmap.put("success",false);
            }
        }catch (RuntimeException e)
        {
            modelmap.put("success",false);
        }
        return modelmap;
    }

    @PostMapping("/edit")
    @ResponseBody
    public Map<String,Object> editRowtodatabase(HttpServletRequest request, HttpSession session, @RequestBody JSONObject jsonParam)
    {
        Map<String,Object> modelmap = new HashMap<>();

        //String userinfo = HttpServletUtil.getString(request,"info");

//        JSONArray json = JSONArray.fromObject(jsonParam);
//        List<UserFullmessagecondition> users= (List<UserFullmessagecondition>)JSONArray.toCollection(json, UserFullmessagecondition.class);

        System.out.println(jsonParam.getString("userName"));
        System.out.println(jsonParam.getString("empCode"));
        System.out.println(jsonParam.getString("departmentId"));
        System.out.println(jsonParam.getString("jobJointime"));
        System.out.println(jsonParam.getString("personDes"));
        System.out.println(jsonParam.getString("personPhone"));
        System.out.println(jsonParam.getString("personEmail"));
        System.out.println(jsonParam.getString("userStatus"));

        User_info confirm = userinfoServices.findByUserName(jsonParam.getString("userName"));
        confirm.setUserName(jsonParam.getString("userName"));
        confirm.setEmpCode(jsonParam.getString("empCode"));
        confirm.setDepartmentId(Integer.parseInt(jsonParam.getString("departmentId")));
        confirm.setJobJointime(DateUtil.ConvertDatetoTimestamp(DateUtil.ConvertStringtoDateyhd(jsonParam.getString("jobJointime"))));
        confirm.setPersonDes(jsonParam.getString("personDes"));
        confirm.setPersonPhone(jsonParam.getString("personPhone"));
        confirm.setPersonEmail(jsonParam.getString("personEmail"));
        confirm.setUserStatus(Integer.parseInt(jsonParam.getString("userStatus")));



        try {
            userinfoServices.save(confirm);
            modelmap.put("success",true);
        }catch (Exception e){
            modelmap.put("success",false);
        }
        return modelmap;
    }

    @GetMapping("/chartsone")
    @ResponseBody
    public Map<String,Object> chartEditone() throws Exception {
        Map<String,Object> modelmap = new HashMap<>();
        List<Chartroomidcondition> chartroomidconditionList=null;
        try {
            List<Object[]> list = affairs.Getmeetuseinfo();

            chartroomidconditionList = convertUtil.castEntity(list,Chartroomidcondition.class);
            modelmap.put("success",true);
            modelmap.put("list",chartroomidconditionList);
        }catch (Exception e){
            modelmap.put("success",false);
            modelmap.put("errMsg",e.getMessage());
        }


        return modelmap;
    }

    @GetMapping("/chartstwo")
    @ResponseBody
    public Map<String,Object> charEdittwo()throws Exception{
        Map<String,Object> modelmap = new HashMap<>();
        List<Meetdistributecondition> meetdistributeconditionList=null;
        List<Meetdistributecondition> meetdistributeconditions = null;
        try {
            List<Object[]> list = affairs.Getmeettimepush();
            List<Object[]> objectList = affairs.Getmeettimepushbyymd();
            meetdistributeconditionList = convertUtil.castEntity(list,Meetdistributecondition.class);
            meetdistributeconditions = convertUtil.castEntity(objectList,Meetdistributecondition.class);
            modelmap.put("success",true);
            modelmap.put("list",meetdistributeconditionList);
            modelmap.put("ymdlist",meetdistributeconditions);
        }catch (Exception e){
            modelmap.put("success",false);
        }
        return modelmap;
    }

    @GetMapping("/chartsthree")
    @ResponseBody
    public Map<String,Object> charEditthree()throws Exception{
        Map<String,Object> modelmap = new HashMap<>();
        List<Userappcondition> userappconditionList=null;
        try {
            List<Object[]> list = affairs.GetuserappList();
            userappconditionList = convertUtil.castEntity(list,Userappcondition.class);
            modelmap.put("success",true);
            modelmap.put("list",userappconditionList);
        }catch (Exception e){
            modelmap.put("success",false);
        }
        return modelmap;
    }

    @PostMapping("/broadcast")
    @ResponseBody
    public Map<String,Object> Broadcast(HttpServletRequest request, HttpSession session, @RequestBody JSONObject jsonParam){
        Map<String,Object> modelmap = new HashMap<>();

        String message = jsonParam.getString("msg");

        try {

            WebSocket.sendMessageAll("广播:"+message);

            modelmap.put("success",true);
        }catch (Exception e){
            modelmap.put("success",false);

        }

        return modelmap;
    }

}
