package top.ysqorz.springcloud.service.impl;

import org.springframework.stereotype.Service;
import top.ysqorz.springcloud.dao.PaymentDao;
import top.ysqorz.springcloud.entities.Payment;
import top.ysqorz.springcloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author passerbyYSQ
 * @create 2022-08-19 22:53
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
