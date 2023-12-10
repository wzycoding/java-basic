package com.wzy.transactional;

import com.wzy.entity.Goods;
import com.wzy.mapper.GoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Transactional(rollbackFor = Exception.class)
    public int addGoods(Goods goods) {
        int count = goodsMapper.insert(goods);

        if (count > 0) {
            System.out.println("==数据插入成功==");
            return count;
        }

        throw new NullPointerException("手动抛出异常");
    }

    @Transactional(rollbackFor = Exception.class)
    void addGoods1(Goods goods) {
        int count = goodsMapper.insert(goods);

        if (count > 0) {
            System.out.println("==数据插入成功==");
        }

        throw new NullPointerException("手动抛出异常");
    }

    public void callAddGoods1(Goods goods) {
        addGoods1(goods);
    }


}
