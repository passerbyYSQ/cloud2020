package top.ysqorz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.ysqorz.springcloud.entities.CommonResult;
import top.ysqorz.springcloud.entities.Payment;
import top.ysqorz.springcloud.service.PaymentService;

import javax.annotation.Resource;

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

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int cnt = paymentService.create(payment);
        log.info("插入成功11111：" + cnt);
        if (cnt == 1) {
            return new CommonResult<>(200, "创建Payment成功，端口号：" + serverPort, payment);
        } else {
            return new CommonResult<>(500, "创建Payment失败，端口号：" + serverPort, null);
        }
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果" + payment);
        return new CommonResult<>(200, "查询Payment成功，端口号：" + serverPort, payment);
    }
}
