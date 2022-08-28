package top.ysqorz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author passerbyYSQ
 * @create 2022-08-28 18:50
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j

public class OrderConsulController {
    public static final String INVOKER_URL = "http://consul-provider-payment/payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consul")
    public String paymentConsul() {
        return restTemplate.getForObject(INVOKER_URL + "/consul", String.class);
    }
}
