package com.mark.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mark.entity.Order;
import com.mark.mapper.OrderMapper;
import com.mark.service.OrderService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public Integer InsertOrder(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public Order findOrder(long id) {
        return orderMapper.selectById(id);
    }

    @Override
    public List<Order> selectOrder() {
        return orderMapper.selectList(new QueryWrapper<>());
    }
}
