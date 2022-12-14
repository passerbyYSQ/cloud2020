package top.ysqorz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import top.ysqorz.springcloud.entities.CommonResult;
import top.ysqorz.springcloud.entities.Payment;
import top.ysqorz.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author passerbyYSQ
 * @create 2022-08-19 22:56
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/lb")
    public CommonResult<String> getPaymentLB() {
        return CommonResult.success("Payment: " + serverPort);
    }

    @GetMapping("/feign/timeout")
    public CommonResult<String> paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CommonResult.success("Payment: " + serverPort);
    }

    @GetMapping("/discovery")
    public CommonResult<List<Map<String, Object>>> discovery() {
        List<String> services = discoveryClient.getServices();
        List<Map<String, Object>> serviceInfoList = services.stream().map(service -> {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            Map<String, Object> serviceInfo = new LinkedHashMap<>();
            serviceInfo.put("service", service);
            serviceInfo.put("instances", instances);
            return serviceInfo;
        }).collect(Collectors.toList());
        return CommonResult.success(serviceInfoList);
    }

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int cnt = paymentService.create(payment);
        log.info("????????????11111???" + cnt);
        if (cnt == 1) {
            return new CommonResult<>(200, "??????Payment?????????????????????" + serverPort, payment);
        } else {
            return new CommonResult<>(500, "??????Payment?????????????????????" + serverPort, null);
        }
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("????????????" + payment);
        return new CommonResult<>(200, "??????Payment?????????????????????" + serverPort, payment);
    }
}
