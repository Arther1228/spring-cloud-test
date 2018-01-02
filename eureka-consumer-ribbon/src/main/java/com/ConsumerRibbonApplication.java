package com;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具。它是一个基于HTTP和TCP的客户端负载均衡器。
 它可以通过在客户端中配置ribbonServerList来设置服务端列表去轮询访问以达到均衡负载的作用。

 当Ribbon与Eureka联合使用时，ribbonServerList会被DiscoveryEnabledNIWSServerList重写，
 扩展成从Eureka注册中心中获取服务实例列表。同时它也会用NIWSDiscoveryPing来取代IPing，
 它将职责委托给Eureka来确定服务端是否已经启动。

 而当Ribbon与Consul联合使用时，ribbonServerList会被ConsulServerList来扩展成从Consul获取服务实例列表。
 同时由ConsulPing来作为IPing接口的实现。

 我们在使用Spring Cloud Ribbon的时候，不论是与Eureka还是Consul结合，
 都会在引入Spring Cloud Eureka或Spring Cloud Consul依赖的时候通过自动化配置来加载上述所说的配置内容，
 所以我们可以快速在Spring Cloud中实现服务间调用的负载均衡。

 * Created by admin on 2017/10/13.
 */
//@EnableJpaRepositories
@EnableJSONDoc
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerRibbonApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsumerRibbonApplication.class).web(true).run(args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("CommandLinerRunnenr");
    }
}
