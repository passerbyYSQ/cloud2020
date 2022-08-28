package top.ysqorz.springcloud.service;

import top.ysqorz.springcloud.entities.Payment;

/**
 * @author passerbyYSQ
 * @create 2022-08-19 22:53
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);

}
