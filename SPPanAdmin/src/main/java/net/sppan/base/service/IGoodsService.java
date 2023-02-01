package net.sppan.base.service;


import net.sppan.base.entity.Goods;
import net.sppan.base.entity.Ground;
import net.sppan.base.service.support.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IGoodsService  extends IBaseService<Goods, Integer> {
    Page<Goods> findAllByLike(String searchText, PageRequest pageRequest);
    void saveOrUpdate(Goods goods);
}
