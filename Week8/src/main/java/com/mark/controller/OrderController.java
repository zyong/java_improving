package com.mark.controller;


import com.mark.entity.Order;
import com.mark.service.Impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl OrderServiceImpl;

    @RequestMapping("/order/get")
    public Order get (@RequestParam int id) {
        return OrderServiceImpl.findOrder(id);
    }

    @RequestMapping("/order/select")
    public List<Order> select () {
        return OrderServiceImpl.selectOrder();
    }
}
