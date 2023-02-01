package net.sppan.base.service.impl;

import net.sppan.base.dao.IFriendDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.ApplyFriend;
import net.sppan.base.entity.Friend;
import net.sppan.base.service.IApplyFriendService;
import net.sppan.base.service.IFriendService;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendSerivceImpl extends BaseServiceImpl<Friend, Integer>
        implements IFriendService {
    @Autowired
    IFriendDao friendDao;
    @Override
    public IBaseDao<Friend, Integer> getBaseDao() {
        return this.friendDao;
    }

    @Override
    public List<Friend> findAllBymyid(Integer id) {
        List<Friend> friends = friendDao.findAllBymyid(id);
        return friends;
    }

    @Override
    public Friend findByfriendid(Integer id) {
        Friend friend = friendDao.findByfriendid(id);
        return friend;
    }

    @Override
    public Integer findByfriendidAndmyid(Integer friendid, Integer myid) {
        return friendDao.findByfriendidAndmyid(friendid,myid);
    }
}
