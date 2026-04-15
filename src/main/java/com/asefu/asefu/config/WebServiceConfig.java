package com.asefu.asefu.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;

import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import org.springframework.xml.xsd.*;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
            ApplicationContext context) {

        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "shapes") // URL: /ws/shapes.wsdl
    public DefaultWsdl11Definition wsdlDefinition(XsdSchema schema) {

        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("ShapeToolPort");
        wsdl.setLocationUri("/ws");

        // ✅ MUST match XSD and Endpoint
        wsdl.setTargetNamespace("http://example.com/shapetool");

        wsdl.setSchema(schema);

        return wsdl;
    }

    @Bean
    public XsdSchema schema() {
        return new SimpleXsdSchema(
                // ✅ FIXED PATH (your file is inside schemas folder)
                new ClassPathResource("schemas/shapes.xsd"));
    }
}