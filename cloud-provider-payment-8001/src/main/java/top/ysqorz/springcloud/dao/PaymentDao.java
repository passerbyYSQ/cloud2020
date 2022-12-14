package top.ysqorz.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.ysqorz.springcloud.entities.Payment;

/**
 * @author passerbyYSQ
 * @create 2022-08-17 22:51
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
