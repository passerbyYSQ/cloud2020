package top.ysqorz.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.ysqorz.cloud.entities.CommonResult;
import top.ysqorz.cloud.entities.Payment;
import top.ysqorz.cloud.service.PaymentService;

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

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int cnt = paymentService.create(payment);
        log.info("插入成功11111：" + cnt);
        if (cnt == 1) {
            return new CommonResult<>(200, "创建Payment成功", payment);
        } else {
            return new CommonResult<>(500, "创建Payment失败", null);
        }
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果" + payment);
        return new CommonResult<>(200, "查询Payment成功", payment);
    }
}
