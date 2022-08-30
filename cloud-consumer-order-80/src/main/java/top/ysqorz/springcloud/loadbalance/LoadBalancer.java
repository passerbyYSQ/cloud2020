package top.ysqorz.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author passerbyYSQ
 * @create 2022-08-30 22:22
 */
public interface LoadBalancer {
    ServiceInstance chooseInstance(List<ServiceInstance> serviceInstances);
}
