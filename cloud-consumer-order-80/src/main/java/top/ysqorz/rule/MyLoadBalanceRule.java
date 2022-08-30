package top.ysqorz.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author passerbyYSQ
 * @create 2022-08-30 21:48
 */
@Configuration
public class MyLoadBalanceRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
