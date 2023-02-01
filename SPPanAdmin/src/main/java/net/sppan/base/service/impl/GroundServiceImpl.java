package net.sppan.base.service.impl;

import net.sppan.base.dao.IGroundDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Ground;
import net.sppan.base.entity.Resource;
import net.sppan.base.service.IGroundService;
import net.sppan.base.service.IResourceService;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GroundServiceImpl extends BaseServiceImpl<Ground, Integer>
        implements IGroundService {
    @Autowired
    IGroundDao iGroundDao;

    @Override
    public IBaseDao<Ground, Integer> getBaseDao() {return this.iGroundDao;}

    @Override
    public Page<Ground> findAllByLike(String searchText, PageRequest pageRequest) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }
        return iGroundDao.findAllByNameContaining(searchText,pageRequest);
    }

    @Override
    public void saveOrUpdate(Ground ground) {
        if (ground.getId()!=null){
            Ground dbg = find(ground.getId());
            dbg.setName(ground.getName());
            update(dbg);
        }else {
            save(ground);
        }
    }
}
