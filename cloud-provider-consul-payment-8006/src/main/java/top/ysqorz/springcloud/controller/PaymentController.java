package top.ysqorz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author passerbyYSQ
 * @create 2022-08-28 18:37
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consul")
    public String paymentConsul() {
        return "SpringCloud with Consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
