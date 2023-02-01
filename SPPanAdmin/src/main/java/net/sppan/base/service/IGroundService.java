package net.sppan.base.service;

import net.sppan.base.entity.Ground;
import net.sppan.base.entity.Resource;
import net.sppan.base.entity.User;
import net.sppan.base.service.support.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IGroundService  extends IBaseService<Ground, Integer> {
    Page<Ground> findAllByLike(String searchText, PageRequest pageRequest);

    void saveOrUpdate(Ground resource);
}
