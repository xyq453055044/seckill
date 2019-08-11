package com.miaosha2.miaosha2.dao;

import com.miaosha2.miaosha2.domain.Goods;
import com.miaosha2.miaosha2.domain.MiaoshaGoods;
import com.miaosha2.miaosha2.vo.GoodsVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xyq
 * @date 2019/08/04
 */
@Mapper
public interface GoodsDao {

    @Select("select g.*, mg.stock_count, mg.start_date, mg.end_date, mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id")
    List<GoodsVo> listGoodsVo();

    @Select("select g.*, mg.stock_count, mg.start_date, mg.end_date, mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id = #{goodsId} ")
    GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

    @Update("update miaosha_goods set stock_count = stock_count - 1 where goods_id = #{goodsId} stock_count > 0")
    int reduceStock(MiaoshaGoods g);
}
