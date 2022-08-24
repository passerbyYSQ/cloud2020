package top.ysqorz.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.ysqorz.springcloud.entities.CommonResult;
import top.ysqorz.springcloud.entities.Payment;

import javax.annotation.Resource;

/**
 * @author passerbyYSQ
 * @create 2022-08-21 23:47
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/create", payment, CommonResult.class);
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getById(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/" + id, CommonResult.class);
    }
}
