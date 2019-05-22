package com.cs.meet.dto;


import lombok.Data;

@Data
public class Userinfocondition {

    public String userName;

    public String loginPassword;

    public String personEmail;

    public String personPhone;


    public Userinfocondition(){

    }

    public Userinfocondition(String userName,
                             String loginPassword,
                             String personEmail,
                             String personPhone){
        this.userName = userName;
        this.loginPassword = loginPassword;
        this.personEmail=personEmail;
        this.personPhone = personPhone;
    }
}
