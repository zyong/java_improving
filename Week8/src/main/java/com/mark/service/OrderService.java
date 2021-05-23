package com.mark.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mark.entity.Order;

import java.util.List;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 */
public interface OrderService extends IService<Order> {

    Integer InsertOrder(Order order);

    Order findOrder(long id);

    List<Order> selectOrder();

}
