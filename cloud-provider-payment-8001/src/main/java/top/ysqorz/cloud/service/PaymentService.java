package top.ysqorz.cloud.service;

import org.apache.ibatis.annotations.Param;
import top.ysqorz.cloud.entities.Payment;

/**
 * @author passerbyYSQ
 * @create 2022-08-19 22:53
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);

}
