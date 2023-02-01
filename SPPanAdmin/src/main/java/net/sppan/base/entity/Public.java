package net.sppan.base.entity;

import com.alibaba.fastjson.annotation.JSONField;
import net.sppan.base.entity.support.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_public")
public class Public extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String content;
    private String name;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date up_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUp_time() {
        return up_time;
    }

    public void setUp_time(Date up_time) {
        this.up_time = up_time;
    }

    public Public() {
    }

    public Public(Integer id, String content, String name, Date up_time) {
        this.id = id;
        this.content = content;
        this.name = name;
        this.up_time = up_time;
    }
}
