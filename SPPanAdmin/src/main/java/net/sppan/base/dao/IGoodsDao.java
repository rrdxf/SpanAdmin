package net.sppan.base.dao;

import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Goods;
import net.sppan.base.entity.Ground;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface IGoodsDao extends IBaseDao<Goods,Integer> {
    Page<Goods> findAllByNameContaining(String searchText, Pageable pageable);
}
