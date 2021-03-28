package cn.icodening.mall.config;

import org.apache.catalina.startup.Tomcat;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.remoting.http.servlet.BootstrapListener;
import org.apache.dubbo.rpc.protocol.rest.RestProtocol;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author icodening
 * @date 2021.03.28
 */
@Configuration
public class DubboConfig {

//    @Bean
//    public ProtocolConfig rest() {
//        ProtocolConfig rest = new ProtocolConfig();
//        rest.setName("rest");
//        rest.setPort(80);
//        rest.setServer("servlet");
//        return rest;
//    }

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
