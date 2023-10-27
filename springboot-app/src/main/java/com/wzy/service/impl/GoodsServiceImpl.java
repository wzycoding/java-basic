package com.wzy.service.impl;

import com.wzy.entity.Goods;
import com.wzy.mapper.GoodsMapper;
import com.wzy.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.insert(goods);
    }
}
