package com.wzy.transactional;


import com.alibaba.fastjson.JSON;
import com.wzy.entity.Goods;
import com.wzy.mapper.GoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionalTest extends GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsService goodsService;

    @Test
    public void testSelectList() {
        List<Goods> goodsList = goodsMapper.selectList(null);

        System.out.println(JSON.toJSONString(goodsList));
    }

    @Test
    public void testAddGoods() {
        Goods goods = new Goods();

        goods.setName("MacBook Pro");
        goods.setStock(20);
        goods.setDescription("果粉必备");
        goods.setMerchantId(1);
        goods.setPrice(999900);

        goodsService.addGoods(goods);
    }


    @Test
    public void testAddGoods1() {
        Goods goods = new Goods();

        goods.setName("MacBook Pro");
        goods.setStock(20);
        goods.setDescription("果粉必备");
        goods.setMerchantId(1);
        goods.setPrice(999900);

        goodsService.addGoods1(goods);
    }


}
