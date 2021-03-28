package cn.icodening.mall;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.AbstractUrlHandlerMapping;
import org.springframework.web.servlet.handler.RequestMatchResult;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author icodening
 * @date 2021.03.28
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class WebApplication{

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class);
    }

    /**
     * 使用Dubbo提供的redis协议，通过java.util.Map完成对Redis Server的简单CRUD
     * 仅能使用单机模式
     * {@link org.apache.dubbo.rpc.protocol.redis.RedisProtocol#protocolBindingRefer(Class, URL)}
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

    @Bean
    public AbstractUrlHandlerMapping mapping() {
        return new AbstractUrlHandlerMapping() {
            @Override
            public RequestMatchResult match(HttpServletRequest request, String pattern) {
                System.out.println(pattern);
                System.out.println(request);
                return super.match(request, pattern);
            }
        };
    }


}
