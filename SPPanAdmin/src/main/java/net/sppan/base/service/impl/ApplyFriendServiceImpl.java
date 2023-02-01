package net.sppan.base.service.impl;

import net.sppan.base.dao.IApplyFriendDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.ApplyFriend;
import net.sppan.base.entity.Friend;
import net.sppan.base.entity.Goods;
import net.sppan.base.service.IApplyFriendService;
import net.sppan.base.service.IGoodsService;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyFriendServiceImpl extends BaseServiceImpl<ApplyFriend, Integer>
        implements IApplyFriendService {
    @Autowired
    IApplyFriendDao applyFriendDao;
    @Override
    public IBaseDao<ApplyFriend, Integer> getBaseDao() {
        return this.applyFriendDao;
    }

    @Override
    public List<ApplyFriend> findAllBymyid(Integer id) {
        List<ApplyFriend> friends = applyFriendDao.findAllBymyid(id);
        return friends;
    }

    @Override
    public ApplyFriend findByfriendid(Integer id) {
        ApplyFriend friend = applyFriendDao.findByfriendid(id);
        return friend;
    }

    @Override
    public Integer findByfriendidAndmyid(Integer friendid, Integer myid) {
        return applyFriendDao.findByfriendidAndmyid(friendid,myid);
    }
}
