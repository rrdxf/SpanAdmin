package net.sppan.base.service;

import net.sppan.base.entity.Ground;
import net.sppan.base.entity.Join;
import net.sppan.base.entity.Play;
import net.sppan.base.service.support.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IJoinSevice  extends IBaseService<Join, Integer> {
    Page<Join> findAllByPlayId(Integer integer, PageRequest pageRequest);
    List<Join> findAllByPlayId(Integer integer);
    List<Join> findAllByUserId(Integer integer);
}
