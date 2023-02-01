package net.sppan.base.dao;

import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.ApplyFriend;
import net.sppan.base.entity.Friend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IApplyFriendDao extends IBaseDao<ApplyFriend,Integer> {
    List<ApplyFriend> findAllBymyid(Integer id);
    ApplyFriend findByfriendid(Integer id);
    @Query("select id from applyfriend where my_id = ?2 and friend_id = ?1")
    Integer findByfriendidAndmyid(Integer friendid,Integer myid);
}
