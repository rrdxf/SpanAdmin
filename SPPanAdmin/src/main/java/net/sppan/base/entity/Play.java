package net.sppan.base.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.sppan.base.entity.support.BaseEntity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "tb_play")
public class Play extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date starttime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endtime;
    private Integer ground_id;
    private Integer joincount;
    @Column(name = "usr_id", nullable = false)
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getGround_id() {
        return ground_id;
    }

    public void setGround_id(Integer ground_id) {
        this.ground_id = ground_id;
    }

    public Integer getJoincount() {
        return joincount;
    }

    public void setJoincount(Integer joincount) {
        this.joincount = joincount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Play(Integer id, String name, Date starttime, Date endtime, Integer ground_id, Integer joincount, Integer userId) {
        this.id = id;
        this.name = name;
        this.starttime = starttime;
        this.endtime = endtime;
        this.ground_id = ground_id;
        this.joincount = joincount;
        this.userId = userId;
    }

    public Play() {
    }
}
