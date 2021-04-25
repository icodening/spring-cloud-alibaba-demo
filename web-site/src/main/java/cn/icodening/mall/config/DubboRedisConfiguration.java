package cn.icodening.mall.config;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.protocol.redis.RedisProtocol;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author icodening
 * @date 2021.04.25
 */
@Configuration
@ConditionalOnClass({ReferenceConfig.class, RedisProtocol.class})
@ConditionalOnProperty(name = "dubbo.protocols.redis.enable", havingValue = "true")
public class DubboRedisConfiguration {

    /**
     * 使用Dubbo提供的redis协议，通过java.util.Map完成对Redis Server的简单CRUD
     * 仅能使用单机模式
     * {@link org.apache.dubbo.rpc.protocol.redis.RedisProtocol#protocolBindingRefer(Class, URL)}
     * 默认仅支持get、set、delete命令，分别对应Map.get, Map.put, Map.remove.
     * 可学习扩展其他使用方式, 扩展需要继承AbstractProtocol
     *
     * @return Proxy Map
     */
    @Bean
    public Map<String, String> redisMap() {
        ReferenceConfig<Map<String, String>> redisMapConfig = new ReferenceConfig<>();
        redisMapConfig.setUrl("redis://127.0.0.1:6379?serialization=fastjson");
        redisMapConfig.setInterface(Map.class);
        return ReferenceConfigCache.getCache().get(redisMapConfig);
    }
}
