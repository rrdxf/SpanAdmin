package net.sppan.base.service;

import net.sppan.base.entity.Ground;
import net.sppan.base.entity.Play;
import net.sppan.base.service.support.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IPlayService  extends IBaseService<Play, Integer> {
    Page<Play> findAllByLike(String searchText, PageRequest pageRequest);
    Page<Play> findAllByUserId(Integer id, PageRequest pageRequest);
    void saveOrUpdate(Play play);
}
