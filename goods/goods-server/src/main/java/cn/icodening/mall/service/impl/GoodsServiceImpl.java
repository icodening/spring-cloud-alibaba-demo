package cn.icodening.mall.service.impl;

import cn.icodening.mall.dao.GoodsRepository;
import cn.icodening.mall.model.Goods;
import cn.icodening.mall.service.AbstractMallService;
import cn.icodening.mall.service.IGoodsService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author icodening
 * @date 2021.03.28
 */
@Service(onconnect = "onConnect", protocol = {"dubbo"})
public class GoodsServiceImpl extends AbstractMallService<Goods, GoodsRepository> implements IGoodsService {

    @Override
    public String onConnect() {
        System.out.println("被连接了");
        return "success";
    }
}
