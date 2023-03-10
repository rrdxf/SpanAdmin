package net.sppan.base.dao;

import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Ground;
import net.sppan.base.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroundDao extends IBaseDao<Ground,Integer> {
    Page<Ground> findAllByNameContaining(String searchText, Pageable pageable);

}
