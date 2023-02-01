package net.sppan.base.service.impl;

import net.sppan.base.dao.IPlayDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Ground;
import net.sppan.base.entity.Play;
import net.sppan.base.service.IGroundService;
import net.sppan.base.service.IPlayService;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PlayServiceImpl extends BaseServiceImpl<Play, Integer>
        implements IPlayService {
    @Autowired
    IPlayDao iPlayDao;

    @Override
    public Page<Play> findAllByLike(String searchText, PageRequest pageRequest) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }
        return iPlayDao.findAllByNameContaining(searchText,pageRequest);
    }

    @Override
    public Page<Play> findAllByUserId(Integer id, PageRequest pageRequest) {
        Page<Play> plays = iPlayDao.findAllByUserId(id,pageRequest);
        return plays;
    }

    @Override
    public void saveOrUpdate(Play play) {
        if (play.getId() != null){
            Play play1 = find(play.getId());
            play1.setName(play.getName());
            play1.setEndtime(play.getEndtime());
            play1.setGround_id(play.getGround_id());
            play1.setStarttime(play.getStarttime());
            play1.setJoincount(play.getJoincount());
            update(play1);
        }else {
            save(play);
        }
    }

    @Override
    public IBaseDao<Play, Integer> getBaseDao() {
        return this.iPlayDao;
    }
}
