package com.wzy;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzy.entity.Goods;
import com.wzy.mapper.GoodsMapper;
import com.wzy.vo.GoodsCategoryVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class FirstDemoTest {
    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void testSelectList() {
        List<Goods> goodsList = goodsMapper.selectList(null);

        System.out.println(JSON.toJSONString(goodsList));
    }

    @Test
    public void testSelectMaps() {
        List<Map<String, Object>> goodsMap = goodsMapper.selectMaps(null);

        System.out.println(JSON.toJSONString(goodsMap));
    }

    @Test
    public void testSelectObjs() {
        List<Object> reslutList = goodsMapper.selectObjs(null);

        System.out.println(JSON.toJSONString(reslutList));
    }

    @Test
    public void testSelectPage() {
        Page<Goods> goodsPage = new Page<>(1, 2);
        goodsPage = goodsMapper.selectPage(goodsPage, null);

        log.info(JSON.toJSONString(goodsPage));
    }

    @Test
    public void testSelectGoodsByCategoryId() {
        Page<GoodsCategoryVO> goodsPage = new Page<>(1, 3);
        // 查询分类为1的商品，即分类为手机
        goodsPage = goodsMapper.selectGoodsByCategoryId(goodsPage, 1L);

        log.info(JSON.toJSONString(goodsPage));
    }

    @Test
    public void testSelectListByWrapper() {
        LambdaQueryWrapper<Goods> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(Goods::getId, 2);
        List<Goods> goodsList = goodsMapper.selectList(queryWrapper);

        System.out.println(JSON.toJSONString(goodsList));
    }
}
