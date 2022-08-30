package top.ysqorz.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author passerbyYSQ
 * @create 2022-08-30 22:23
 */
@Component
public class MyLoadBalancerImpl implements LoadBalancer {
    private final AtomicInteger currIndex = new AtomicInteger(-1);

    private int getAndIncrement(int serverCount) {
        int curr, next;
        do {
            curr = currIndex.get();
            next = (curr < serverCount - 1 ? curr + 1 : 0);
        } while (!currIndex.compareAndSet(curr, next));
        System.out.println("next = " + next);
        return next;
    }

    @Override
    public ServiceInstance chooseInstance(List<ServiceInstance> serviceInstances) {
        int next = getAndIncrement(serviceInstances.size());
        return serviceInstances.get(next);
    }
}
