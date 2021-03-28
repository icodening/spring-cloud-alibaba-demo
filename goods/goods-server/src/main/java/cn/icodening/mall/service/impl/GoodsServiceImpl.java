package cn.icodening.mall.service.impl;

import cn.icodening.mall.dao.GoodsRepository;
import cn.icodening.mall.model.Goods;
import cn.icodening.mall.service.AbstractMallService;
import cn.icodening.mall.service.IGoodsService;
import org.apache.dubbo.config.annotation.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author icodening
 * @date 2021.03.28
 */
@Service(protocol = "dubbo")
public class GoodsServiceImpl extends AbstractMallService<Goods, GoodsRepository> implements IGoodsService {

    @Override
    public List<Goods> findAll() {
        List<Goods> goodsList = new ArrayList<>();
        Goods goods = new Goods();
        goods.setName("abc");
        goodsList.add(goods);
        Goods goods2 = new Goods();
        goods2.setName("bcd");
        goodsList.add(goods2);
        return goodsList;
    }
}
