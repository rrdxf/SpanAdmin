package net.sppan.base.dao;

import net.sppan.base.dao.support.IBaseDao;
import net.sppan.base.entity.Ground;
import net.sppan.base.entity.Play;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayDao extends IBaseDao<Play,Integer> {
    Page<Play> findAllByNameContaining(String searchText, Pageable pageable);
    Page<Play> findAllByUserId(Integer id,Pageable pageable);
}
