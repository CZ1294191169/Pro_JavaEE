package com.cs.meet.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@DynamicUpdate//动态更新
public class Affairs_people {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer peopleId;

    public Integer affairsId;

    public Integer userId;

//    public Affairpeople(){
//
//    }
//
//    public Affairpeople(Integer peopleId,
//                        Integer affairsId,
//                        Integer userId){
//        this.peopleId = peopleId;
//        this.affairsId = affairsId;
//        this.userId = userId;
//    }
}
