package com.cs.meet.controller;

import com.cs.meet.dto.Client2ServerMessage;
import com.cs.meet.dto.Server2ClientMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//这暂时是一个废弃的控制器
//@RestController
public class WebSocketController {

//    @RequestMapping("/hello") //
//    @SendTo("/nasus/getResponse") //
//    public Server2ClientMessage say(Client2ServerMessage message) throws Exception {
//        System.out.println("i'm here");
//        Thread.sleep(1000);
//        System.out.println(message.getName());
//        return new Server2ClientMessage("Hello," + message.getName() + "!");
//    }

}

