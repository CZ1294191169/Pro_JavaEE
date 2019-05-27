package com.cs.meet.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@DynamicUpdate//动态更新
@Data
public class Meeting_log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logId;//会议记录编号

    private Integer affairsId;//事务编号

    private Integer userId;//用户编号

    private Integer roomId;//会议室编号

    private String theme;//会议室主题

    private String file;//会议文件

    private Integer participate;//参会人数

    private String meetingSummarize;//会议总结

    private String meetingImg;//会议现场图片

    private Date arrangementPeriodstart;//会议开始时间

    private Date arrangementPeriodend;//会议结束时间

    private Date createTime;//创建时间

    private Date editTime;//修改时间

    @OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "MM_id", referencedColumnName = "room_id")
    private Meeting_room meetingRoom;

    @OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "MU_id", referencedColumnName = "user_id")
    private User_info userInfo;

//    @OneToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name="Affairs_table_affairsId",nullable=false)
//    private Affairs_table affairsTable;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this,true);
    }

}
