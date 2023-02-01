package net.sppan.base.dao;

import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Friend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFriendDao extends IBaseDao<Friend,Integer> {
    List<Friend> findAllBymyid(Integer id);
    Friend findByfriendid(Integer id);
    @Query("select id from friend where my_id = ?2 and friend_id = ?1")
    Integer findByfriendidAndmyid(Integer friendid,Integer myid);
}
