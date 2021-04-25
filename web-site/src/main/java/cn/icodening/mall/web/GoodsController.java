package cn.icodening.mall.web;

import cn.icodening.mall.service.IGoodsService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.service.EchoService;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.checkerframework.common.reflection.qual.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Reference(protocol = "dubbo", check = false)
    private IGoodsService goodsService;

    @Autowired(required = false)
    private DefaultMQProducer producer;

    @GetMapping
    public Object list() {
        return goodsService.findAll();
    }


    @GetMapping("/mq")
    public Object producer() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        if (producer != null) {
            SendResult topic = producer.send(new Message("topic", "body".getBytes()));
        }
        return "success";
    }

    @GetMapping("/echo")
    public Object echo(String msg) {
        return ((EchoService) goodsService).$echo(msg);
    }
}
