package top.ysqorz.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.ysqorz.springcloud.entities.CommonResult;
import top.ysqorz.springcloud.entities.Payment;

/**
 * @author passerbyYSQ
 * @create 2022-08-21 23:47
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderController extends BaseController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/payment";

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        // return restTemplate.postForObject(PAYMENT_URL + "/create", payment, CommonResult.class);
        return this.post(PAYMENT_URL + "/create", payment, Payment.class);
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getById(@PathVariable Long id) {
        // return restTemplate.getForObject(PAYMENT_URL + "/" + id, CommonResult.class);
        return this.get(PAYMENT_URL + "/" + id, null, Payment.class);
    }

}
