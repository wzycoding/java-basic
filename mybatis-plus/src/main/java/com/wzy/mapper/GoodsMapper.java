package com.wzy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzy.entity.Goods;
import com.wzy.vo.GoodsCategoryVO;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     * 通过商品分类id查询商品信息
     *
     * @param page       分页参数
     * @param categoryId 分类id
     * @return 商品列表
     */
    Page<GoodsCategoryVO> selectGoodsByCategoryId(
            Page<GoodsCategoryVO> page,
            @Param("categoryId") Long categoryId);
}
