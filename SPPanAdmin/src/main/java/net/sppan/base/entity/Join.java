package net.sppan.base.entity;

import net.sppan.base.entity.support.BaseEntity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "tb_join")
public class Join  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "user_id")
    private Integer userid;
    @Column(name = "play_id")
    private Integer playid;
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    @OneToOne(targetEntity=User.class,cascade=CascadeType.DETACH)
    private User joinuser;
    @JoinColumn(name = "play_id",insertable = false,updatable = false)
    @OneToOne(targetEntity=Play.class,cascade=CascadeType.DETACH)
    private Play play;
    private String role;
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Join(Integer id, Integer userid, Integer playid, User joinuser, Play play, String role, Integer status) {
        this.id = id;
        this.userid = userid;
        this.playid = playid;
        this.joinuser = joinuser;
        this.play = play;
        this.role = role;
        this.status = status;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getPlayid() {
        return playid;
    }

    public void setPlayid(Integer playid) {
        this.playid = playid;
    }

    public User getJoinuser() {
        return joinuser;
    }

    public void setJoinuser(User joinuser) {
        this.joinuser = joinuser;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Join() {
    }

    public Join(Integer id, Integer user_id, Integer playid, User joinuser, Play play, String role) {
        this.id = id;
        this.userid = user_id;
        this.playid = playid;
        this.joinuser = joinuser;
        this.play = play;
        this.role = role;
    }
}
