package cn.icodening.mall.web;

import cn.icodening.mall.service.IGoodsService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.service.EchoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author icodening
 * @date 2021.03.28
 */
@RequestMapping("/goods")
@RestController
public class GoodsController {

    @Reference(protocol = "dubbo")
    private IGoodsService goodsService;

    @GetMapping
    public Object list() {
        return goodsService.findAll();
    }

    @GetMapping("/echo")
    public Object echo(String msg) {
        return ((EchoService) goodsService).$echo(msg);
    }
}
