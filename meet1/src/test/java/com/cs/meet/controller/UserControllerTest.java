package com.cs.meet.controller;

import com.cs.meet.entity.User_info;
import com.cs.meet.services.UserinfoServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    UserinfoServices userinfoServices;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void whenquery(){
        try {
            String result = mockMvc.perform(MockMvcRequestBuilders.get("/user")
                    .param("userName","陈政")
                    .param("userCode","123")
                    .param("departmentId","1")
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                    .andReturn().getResponse().getContentAsString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenget(){
        try {
            String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("chenz"))
                .andReturn().getResponse().getContentAsString()
                ;
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void create(){
        try {
            String content="{\"userName\":\"chenz\",\"loginPassword\":null}";
            mockMvc.perform(MockMvcRequestBuilders.post("/user")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(content))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update(){
        try {
            String content="{\"userId\":\"1\",\"userName\":\"chenz\",\"loginPassword\":null}";
            mockMvc.perform(MockMvcRequestBuilders.put("/user/1")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(content))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value("1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void delete(){
        try {
            String content="{\"userId\":\"1\",\"userName\":\"chenz\",\"loginPassword\":null}";
            mockMvc.perform(MockMvcRequestBuilders.delete("/user/1")
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                   ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
