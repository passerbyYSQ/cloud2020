package top.ysqorz.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.ysqorz.springcloud.entities.CommonResult;
import top.ysqorz.springcloud.entities.Payment;

/**
 * @author passerbyYSQ
 * @create 2022-09-01 22:28
 */
@Service
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    // 必须写作 @PathVariable("id")，不能写作 @PathVariable，否则无法启动
    @GetMapping("/payment/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    CommonResult<String> paymentFeignTimeout();
}
