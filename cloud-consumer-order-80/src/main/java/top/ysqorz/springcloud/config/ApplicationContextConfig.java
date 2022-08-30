package top.ysqorz.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author passerbyYSQ
 * @create 2022-08-21 23:51
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //@LoadBalanced // 赋予RestTemplate负载均衡的能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
