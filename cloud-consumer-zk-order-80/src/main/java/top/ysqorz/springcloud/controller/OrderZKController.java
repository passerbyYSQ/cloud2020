package top.ysqorz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author passerbyYSQ
 * @create 2022-08-27 21:16
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderZKController {
    public static final String INVOKER_URL = "http://cloud-provider-payment/payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/zk")
    public String paymentZk() {
        return restTemplate.getForObject(INVOKER_URL + "/zk", String.class);
    }
}
