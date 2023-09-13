package com.wzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.wzy.dao.StockMapper;
import com.wzy.entity.Stock;
import com.wzy.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class StockServiceImpl implements StockService {

    @Resource
    private StockMapper stockMapper;

    @Override
    public Integer deduct(Integer productId, Integer count) {
        LambdaUpdateWrapper<Stock> updateWrapper = new LambdaUpdateWrapper<>();

        updateWrapper.eq(Stock::getProductId, productId);
        updateWrapper.setSql("count = count - " + count);
        updateWrapper.ge(Stock::getCount, count);

        return stockMapper.update(null, updateWrapper);
    }
}
