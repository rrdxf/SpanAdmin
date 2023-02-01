package net.sppan.base.dao;

import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Goods;
import net.sppan.base.entity.Join;
import net.sppan.base.entity.Play;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJoinDao extends IBaseDao<Join,Integer> {
    Page<Join> findAllByPlayid(Integer id, Pageable pageable);
    List<Join> findAllByPlayid(Integer id);
    List<Join> findAllByUserid(Integer id);
}
