package com.wzy;

import com.wzy.entity.Goods;
import com.wzy.mapper.GoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsServiceMockitoTest {

    @Autowired
    private GoodsService goodsService;

    @MockBean
    private GoodsMapper goodsMapper;

    @Test
    public void testMock() {
        Mockito.when(goodsMapper.insert(new Goods())).thenReturn(120);
        int rows = goodsService.addGoods(new Goods());
        log.info("插入行数为：" + rows);
    }
}
