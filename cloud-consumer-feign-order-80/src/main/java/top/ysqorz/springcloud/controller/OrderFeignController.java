package top.ysqorz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ysqorz.springcloud.entities.CommonResult;
import top.ysqorz.springcloud.entities.Payment;
import top.ysqorz.springcloud.service.PaymentFeignService;

import javax.annotation.Resource;

/**
 * @author passerbyYSQ
 * @create 2022-09-01 22:33
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/feign/timeout")
    public CommonResult<String> paymentFeignTimeout() {
        return paymentFeignService.paymentFeignTimeout();
    }
}
