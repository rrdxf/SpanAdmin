package net.sppan.base.service;

import net.sppan.base.entity.ApplyFriend;
import net.sppan.base.entity.Friend;
import net.sppan.base.entity.Goods;
import net.sppan.base.service.support.IBaseService;

import java.util.List;

public interface IApplyFriendService extends IBaseService<ApplyFriend, Integer> {
    List<ApplyFriend> findAllBymyid(Integer id);
    ApplyFriend findByfriendid(Integer id);
    Integer findByfriendidAndmyid(Integer friendid,Integer myid);
}
