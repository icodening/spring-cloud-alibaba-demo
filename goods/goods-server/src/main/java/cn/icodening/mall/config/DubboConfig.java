package cn.icodening.mall.config;

import org.apache.dubbo.config.ProtocolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author icodening
 * @date 2021.03.28
 */
@Configuration
public class DubboConfig {

    /**
     * 往容器添加一个dubbo协议bean, bean名必须是Dubbo所支持的协议
     * 当需要将服务暴露为多种协议时，需要在pom中添加对应的依赖。
     * 并且Spring容器中必须存在一个对应协议的bean
     *
     * @return dubbo protocol
     */
    @Bean
    public ProtocolConfig dubbo() {
        ProtocolConfig dubbo = new ProtocolConfig("dubbo");
        dubbo.setPort(-1);
        return dubbo;
    }

    /**
     * 当使用Dubbo的rest或http协议时，且server配置为Servlet时,
     * 需要往Servlet容器添加 {@link org.apache.dubbo.remoting.http.servlet.BootstrapListener}
     * SpringBoot内置容器需要使用WebServerFactoryCustomizer对WebServer工厂定制化
     *
     * @return WebServerFactoryCustomizer
     */
//    @Bean
//    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatServletWebServerFactoryWebServerFactoryCustomizer() {
//        return new WebServerFactoryCustomizer<TomcatServletWebServerFactory>() {
//
//            @Override
//            public void customize(TomcatServletWebServerFactory factory) {
//                factory.addWebListeners("org.apache.dubbo.remoting.http.servlet.BootstrapListener");
//            }
//        };
//    }
}
