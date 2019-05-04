package com.yqboots.social.wechat.server.config;

import com.yqboots.social.wechat.constants.WeChatConstants;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/ws/*");
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11DefinitionForOrderQuery() {
        DefaultWsdl11Definition bean = new DefaultWsdl11Definition();
        bean.setPortTypeName("WeChatOrderQueryPortType");
        bean.setLocationUri("/weChatPayService");
        bean.setTargetNamespace(WeChatConstants.NAMESPACE_URI);
        bean.setSchema(schemaForOrderQuery());
        return bean;
    }

    @Bean
    public XsdSchema schemaForOrderQuery() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/wechat-order-query.xsd"));
    }
}
