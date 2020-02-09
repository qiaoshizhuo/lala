package com.cloud.ribbon.service;

import com.cloud.ribbon.entity.product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;


public interface GoodsService {
    Page<product> getPage(Integer page, Integer size);

    Optional<product> getGoods(Long p_id);

}
