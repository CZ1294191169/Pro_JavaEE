package com.cs.meet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableScheduling
public class MeetApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetApplication.class, args);
    }


        @GetMapping("/tet")
        public String say(){
        return "security test!";
        }

}
