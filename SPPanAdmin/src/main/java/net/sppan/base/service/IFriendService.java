package net.sppan.base.service;

import net.sppan.base.entity.Friend;
import net.sppan.base.service.support.IBaseService;

import java.util.List;

public interface IFriendService extends IBaseService<Friend, Integer> {
    List<Friend> findAllBymyid(Integer id);
    Friend findByfriendid(Integer id);
    Integer findByfriendidAndmyid(Integer friendid,Integer myid);
}
