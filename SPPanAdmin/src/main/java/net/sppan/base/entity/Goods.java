package net.sppan.base.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.sppan.base.entity.support.BaseEntity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
@Table(name = "tb_goods")
public class Goods extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date in_time;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date out_time;
    private Integer user_id;

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

    public Date getIn_time() {
        return in_time;
    }

    public void setIn_time(Date in_time) {
        this.in_time = in_time;
    }

    public Date getOut_time() {
        return out_time;
    }

    public void setOut_time(Date out_time) {
        this.out_time = out_time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Goods(Integer id, String name, Date in_time, Date out_time, Integer user_id) {
        this.id = id;
        this.name = name;
        this.in_time = in_time;
        this.out_time = out_time;
        this.user_id = user_id;
    }

    public Goods() {
    }
}
