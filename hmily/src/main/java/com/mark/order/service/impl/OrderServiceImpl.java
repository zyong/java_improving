/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mark.order.service.impl;

import com.mark.order.entity.Order;
import com.mark.order.enums.OrderStatusEnum;
import com.mark.order.mapper.OrderMapper;
import org.dromara.hmily.common.utils.IdWorkerUtils;
import com.mark.order.service.OrderService;
import com.mark.order.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;


@Service("orderService")
@SuppressWarnings("all")
public class OrderServiceImpl implements OrderService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderMapper orderMapper;

    private final PaymentService paymentService;

    @Autowired(required = false)
    public OrderServiceImpl(OrderMapper orderMapper,
                            PaymentService paymentService) {
        this.orderMapper = orderMapper;
        this.paymentService = paymentService;
    }

    @Override
    public String orderPay(Integer count, BigDecimal amount) {
        Order order = saveOrder(count, amount);
        long start = System.currentTimeMillis();
        paymentService.makePayment(order);
        System.out.println("???????????????" + (System.currentTimeMillis() - start));
        return "success";
    }
    
    @Override
    public String testOrderPay(Integer count, BigDecimal amount) {
        Order order = saveOrder(count, amount);
        final long start = System.currentTimeMillis();
        paymentService.testMakePayment(order);
        System.out.println("???????????????" + (System.currentTimeMillis() - start));
        return "success";
    }

    /**
     * ??????????????????????????????????????????????????????????????????????????????
     * in this  Inventory nested in account.
     *
     * @param count  ????????????
     * @param amount ????????????
     * @return string
     */
    @Override
    public String orderPayWithNested(Integer count, BigDecimal amount) {
        Order order = saveOrder(count, amount);
        paymentService.makePaymentWithNested(order);
        return "success";
    }
    
    @Override
    public String orderPayWithNestedException(Integer count, BigDecimal amount) {
        Order order = saveOrder(count, amount);
        paymentService.makePaymentWithNestedException(order);
        return "success";
    }
    
    /**
     * ??????????????????????????????????????????try????????????????????????
     *
     * @param count  ????????????
     * @param amount ????????????
     * @return string
     */
    @Override
    public String mockInventoryWithTryException(Integer count, BigDecimal amount) {
        Order order = saveOrder(count, amount);
        return paymentService.mockPaymentInventoryWithTryException(order);
    }
    
    /**
     * ??????????????????????????????????????????try????????????timeout
     *
     * @param count  ????????????
     * @param amount ????????????
     * @return string
     */
    @Override
    @Transactional
    public String mockInventoryWithTryTimeout(Integer count, BigDecimal amount) {
        Order order = saveOrder(count, amount);
        paymentService.mockPaymentInventoryWithTryTimeout(order);
        return "success";
    }
    
    @Override
    public String mockAccountWithTryException(Integer count, BigDecimal amount) {
        Order order = saveOrder(count, amount);
        paymentService.mockPaymentAccountWithTryException(order);
        return "success";
    }
    
    @Override
    public String mockAccountWithTryTimeout(Integer count, BigDecimal amount) {
        Order order = saveOrder(count, amount);
        paymentService.mockPaymentAccountWithTryTimeout(order);
        return "success";
    }
    
    
    /**
     * ??????????????????????????????????????????Confirm????????????timeout
     *
     * @param count  ????????????
     * @param amount ????????????
     * @return string
     */
    @Override
    public String mockInventoryWithConfirmTimeout(Integer count, BigDecimal amount) {
        Order order = saveOrder(count, amount);
        paymentService.mockPaymentInventoryWithConfirmTimeout(order);
        return "success";
    }
    
    @Override
    public boolean updateOrderStatus(Order order) {
        return orderMapper.update(order) > 0;
    }
    
    private Order saveOrder(Integer count, BigDecimal amount) {
        final Order order = buildOrder(count, amount);
        orderMapper.save(order);
        return order;
    }
    
    private Order buildOrder(Integer count, BigDecimal amount) {
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setNumber(String.valueOf(IdWorkerUtils.getInstance().createUUID()));
        //demo????????????????????????id???1?????????
        order.setProductId("1");
        order.setStatus(OrderStatusEnum.NOT_PAY.getCode());
        order.setTotalAmount(amount);
        order.setCount(count);
        //demo??? ?????????????????????id???10000
        order.setUserId("10000");
        return order;
    }

    private Order buildTestOrder(Integer count, BigDecimal amount) {
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setNumber(String.valueOf(IdWorkerUtils.getInstance().createUUID()));
        //demo????????????????????????id???1?????????
        order.setProductId("1");
        order.setStatus(OrderStatusEnum.PAY_SUCCESS.getCode());
        order.setTotalAmount(amount);
        order.setCount(count);
        //demo??? ?????????????????????id???10000
        order.setUserId("10000");
        return order;
    }
}
