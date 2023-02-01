package net.sppan.base.service.impl;

import net.sppan.base.dao.IGoodsDao;
import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Goods;
import net.sppan.base.entity.Ground;
import net.sppan.base.service.IGoodsService;
import net.sppan.base.service.IGroundService;
import net.sppan.base.service.support.IBaseService;
import net.sppan.base.service.support.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GoodsServieImpl extends BaseServiceImpl<Goods, Integer>
        implements IGoodsService {
    @Autowired
    IGoodsDao goodsDao;
    @Override
    public Page<Goods> findAllByLike(String searchText, PageRequest pageRequest) {
        if(StringUtils.isBlank(searchText)){
            searchText = "";
        }
        return goodsDao.findAllByNameContaining(searchText,pageRequest);
    }

    @Override
    public void saveOrUpdate(Goods goods) {
        if (goods.getId() != null){
            Goods goods1 = find(goods.getId());
            goods1.setName(goods.getName());
            goods1.setIn_time(goods.getIn_time());
            goods1.setOut_time(goods.getOut_time());
            goods1.setUser_id(goods.getUser_id());
        }else {
            save(goods);
        }
    }

    @Override
    public IBaseDao<Goods, Integer> getBaseDao() {
        return this.goodsDao;
    }
}
