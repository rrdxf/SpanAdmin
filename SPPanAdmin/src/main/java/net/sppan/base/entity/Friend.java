package net.sppan.base.entity;

import net.sppan.base.entity.support.BaseEntity;

import javax.persistence.*;

@Entity(name = "friend")
@Table(name = "tb_friend")
public class Friend extends BaseEntity {
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
    public Integer getMyid() {
        return myid;
    }

    public void setFriendid(Integer friendid) {
        this.friendid = friendid;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Friend(Integer id, Integer myid, Integer friendid, User friend) {
        this.id = id;
        this.myid = myid;
        this.friendid = friendid;
        this.friend = friend;
    }

    public void setMyid(Integer myid) {
        this.myid = myid;
    }

    public Integer getFriendid() {
        return friendid;
    }

    public Friend(Integer myid, Integer friendid, User friend) {
        this.myid = myid;
        this.friendid = friendid;
        this.friend = friend;
    }

    public Friend() {
    }
}
