package com.cloud.ribbon.service.impl;

import com.cloud.ribbon.entity.product;
import com.cloud.ribbon.repository.GoodsRepository;
import com.cloud.ribbon.service.GoodsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsRepository goodsRepository;


    @Override
    public Page<product> getPage(Integer page, Integer size) {
        Pageable pageable =new PageRequest(page-1,size);
        return goodsRepository.findAll(pageable);
    }

    @Override
    public Optional<product> getGoods(Long p_id) {
        return goodsRepository.findById(p_id);
    }

}
