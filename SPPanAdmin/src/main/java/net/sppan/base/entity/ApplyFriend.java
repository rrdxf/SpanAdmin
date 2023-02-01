package net.sppan.base.entity;


import net.sppan.base.entity.support.BaseEntity;

import javax.persistence.*;


@Entity(name = "applyfriend")
@Table(name = "tb_applyfriend")
public class ApplyFriend  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "my_id")
    private Integer myid;
    @Column(name = "friend_id")
    private Integer friendid;
    @JoinColumn(name = "friend_id",insertable = false,updatable = false)
    @OneToOne(targetEntity=User.class,cascade= CascadeType.DETACH)
    private User friend;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public ApplyFriend(Integer id, Integer myid, Integer friendid, User friend) {
        this.id = id;
        this.myid = myid;
        this.friendid = friendid;
        this.friend = friend;
    }

    public Integer getMyid() {
        return myid;
    }

    public void setMyid(Integer myid) {
        this.myid = myid;
    }

    public Integer getFriendid() {
        return friendid;
    }

    public void setFriendid(Integer friendid) {
        this.friendid = friendid;
    }

    public ApplyFriend(Integer myid, Integer friendid) {
        this.myid = myid;
        this.friendid = friendid;
    }

    public ApplyFriend(Integer myid, Integer friendid, User friend) {
        this.myid = myid;
        this.friendid = friendid;
        this.friend = friend;
    }

    public ApplyFriend() {
    }
}
