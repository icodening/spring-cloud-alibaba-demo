package cn.icodening.mall.service.impl;

import cn.icodening.mall.dao.GoodsRepository;
import cn.icodening.mall.model.Goods;
import cn.icodening.mall.service.AbstractMallService;
import cn.icodening.mall.service.IGoodsService;
import org.apache.dubbo.config.annotation.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author icodening
 * @date 2021.03.28
 */
@Service
public class GoodsServiceImpl extends AbstractMallService<Goods, GoodsRepository> implements IGoodsService {


    @Override
    public List<Goods> findAll() {
        List<Goods> goodsList = new ArrayList<>();
        Goods goods1 = new Goods();
        goods1.setName("abc");
        goods1.setCreateTime(new Date());
        goods1.setPrice(BigDecimal.TEN);
        goods1.setModifyTime(new Date());
        goodsList.add(goods1);

        Goods goods2 = new Goods();
        goods2.setName("bcd");
        goods2.setCreateTime(new Date());
        goods2.setPrice(BigDecimal.ONE);
        goods2.setModifyTime(new Date());
        goodsList.add(goods2);
        return goodsList;
    }
}
