package top.ysqorz.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import top.ysqorz.springcloud.entities.CommonResult;
import top.ysqorz.springcloud.entities.Payment;
import top.ysqorz.springcloud.loadbalance.LoadBalancer;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author passerbyYSQ
 * @create 2022-08-21 23:47
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderController extends BaseController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment";
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        // return restTemplate.postForObject(PAYMENT_URL + "/create", payment, CommonResult.class);
        return this.post(PAYMENT_URL + "/create", payment, Payment.class);
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getById(@PathVariable Long id) {
        // return restTemplate.getForObject(PAYMENT_URL + "/" + id, CommonResult.class);
        return this.get(PAYMENT_URL + "/" + id, Payment.class);
    }

    @GetMapping("/lb")
    public CommonResult<String> getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.isEmpty()) {
            return new CommonResult<>(500, "暂无可用的Payment服务");
        }
        ServiceInstance serviceInstance = loadBalancer.chooseInstance(instances);
        String invokeUrl = serviceInstance.getUri() + "/payment/lb";
        return this.get(invokeUrl, String.class);
    }
}
