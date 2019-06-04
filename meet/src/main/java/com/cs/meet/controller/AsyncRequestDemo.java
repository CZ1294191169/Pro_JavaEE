package com.cs.meet.controller;

import com.cs.meet.entity.Affairs_table;
import com.cs.meet.entity.Message_log;
import com.cs.meet.entity.User_info;
import com.cs.meet.services.MessageServices;
import com.cs.meet.services.UserinfoServices;
import com.cs.meet.services.servicesImpl.AsyncRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RequestMapping("/async")
@RestController
public class AsyncRequestDemo {

    @Autowired
    private AsyncRequestService asyncRequestService;


    @Autowired
    MessageServices messageServices;

    @Autowired
    UserinfoServices userinfoServices;



    @PostMapping("/message")
    public Map<String,Object> messageList(HttpSession session)
    {
        User_info user_info = new User_info();
        Affairs_table affairs_table = new Affairs_table();
        user_info = (User_info) session.getAttribute("user");
        user_info = userinfoServices.findByUserCode(user_info.getUserCode());
        Map<String, Object> modelmap = new HashMap<>();
        try{
            List<Message_log> messageLogs = messageServices.findByUserId(user_info.getUserId());
            modelmap.put("messagelogs",messageLogs);
            modelmap.put("success",true);
        }catch (Exception e){
            modelmap.put("success",false);
        }

        return modelmap;
    }

    @PostMapping("/value")
    public void postValue(String msg) {
        asyncRequestService.postValue(msg);
    }
}


