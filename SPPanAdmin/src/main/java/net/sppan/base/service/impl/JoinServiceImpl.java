package net.sppan.base.service.impl;

import net.sppan.base.dao.IJoinDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Join;
import net.sppan.base.entity.Play;
import net.sppan.base.service.IJoinSevice;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinServiceImpl extends BaseServiceImpl<Join, Integer>
        implements IJoinSevice {
    @Autowired
    IJoinDao joinDao;
    @Override
    public Page<Join> findAllByPlayId(Integer integer, PageRequest pageRequest) {
        Page<Join> page = joinDao.findAllByPlayid(integer,pageRequest);
        return page;
    }

    @Override
    public List<Join> findAllByPlayId(Integer integer) {
        List<Join> list = joinDao.findAllByPlayid(integer);
        return list;
    }

    @Override
    public List<Join> findAllByUserId(Integer integer) {
        List<Join> list = joinDao.findAllByUserid(integer);
        return list;
    }

    @Override
    public IBaseDao<Join, Integer> getBaseDao() {
        return this.joinDao;
    }
}
