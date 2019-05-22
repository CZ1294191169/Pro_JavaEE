package com.cs.meet.controller;

import com.cs.meet.dto.AppUser;
import com.cs.meet.dto.Meetroomcondition;
import com.cs.meet.entity.Affairs_table;
import com.cs.meet.entity.User_info;
import com.cs.meet.services.MeetroomServices;
import com.cs.meet.services.UserinfoServices;
import com.cs.meet.services.affairsServices;
import com.cs.meet.util.DateUtil;
import com.cs.meet.util.HttpServletUtil;
import com.cs.meet.util.convertUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class TableController {

    @Autowired
    MeetroomServices meetroomServicese;

    @Autowired
    UserinfoServices userinfoServices;

    @Autowired

    com.cs.meet.services.affairsServices affairsServices;



    @GetMapping("/init")
    public Map<String,Object> Init(HttpSession session) throws Exception {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        User_info user_info = new User_info();
        user_info = (User_info) session.getAttribute("user");
        user_info = userinfoServices.findByUserCode(user_info.getUserCode());
        List<Object[]> list = meetroomServicese.findall();
        List<Meetroomcondition> meetroomconditionList = convertUtil.castEntity(list,Meetroomcondition.class);

        modelMap.put("meetroomlist",meetroomconditionList);
        modelMap.put("user",user_info);
        modelMap.put("success",true);
        return modelMap;
    }

    @PostMapping(value = "/insert")
    public Map<String,Object> Insert(HttpServletRequest request, HttpSession session){
        Map<String, Object> modelMap = new HashMap<String ,Object>();
        User_info user_info = new User_info();
        Affairs_table table = new Affairs_table();
        user_info = (User_info) session.getAttribute("user");
        user_info = userinfoServices.findByUserCode(user_info.getUserCode());
        String affirs = HttpServletUtil.getString(request,"info");

        ObjectMapper mapper = new ObjectMapper();

        AppUser appUser = null;
        try{
            appUser = mapper.readValue(affirs,AppUser.class);
            table.setUserId(user_info.getUserId());
            table.setRoomId(appUser.roomId);
            table.setAffairsStatus(0);
            if(!appUser.getFile().equals("FILE/undefined")) {
                table.setFile(appUser.file);
            }
            else {
                table.setFile("无");
            }

            table.setArrangementPeriodstart(DateUtil.ConvertTimeStamptodate(appUser.arrangementPeriodstart));
            table.setArrangementPeriodend(DateUtil.ConvertTimeStamptodate(appUser.arrangementPeriodend));
            table.setParticipate(appUser.participate);
            table.setTheme(appUser.theme);

            affairsServices.save(table);

            modelMap.put("success",true);
        }catch (Exception e)
        {
            modelMap.put("success",false);
        }

        return modelMap;
    }

}
