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


import com.mark.order.api.AccountService;
import com.mark.order.api.InventoryService;
import com.mark.order.dto.AccountDTO;
import com.mark.order.dto.AccountNestedDTO;
import com.mark.order.dto.InventoryDTO;
import com.mark.order.entity.AccountDO;
import com.mark.order.entity.Order;
import com.mark.order.enums.OrderStatusEnum;
import com.mark.order.mapper.OrderMapper;
import org.dromara.hmily.annotation.HmilyTCC;
import org.dromara.hmily.common.exception.HmilyRuntimeException;
import com.mark.order.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    private final OrderMapper orderMapper;

    private final AccountService accountService;

    private final InventoryService inventoryService;

    @Autowired(required = false)
    public PaymentServiceImpl(OrderMapper orderMapper,
                              AccountService accountService,
                              InventoryService inventoryService) {
        this.orderMapper = orderMapper;
        this.accountService = accountService;
        this.inventoryService = inventoryService;
    }
    
    @Override
    @HmilyTCC(confirmMethod = "confirmOrderStatus", cancelMethod = "cancelOrderStatus")
    public void makePayment(Order order) {
        updateOrderStatus(order, OrderStatusEnum.PAYING);
        //??????????????????????????????????????? ????????????demo ?????????
       /* final AccountDO accountDO = accountService.findByUserId(order.getUserId());
        if (accountDO.getBalance().compareTo(order.getTotalAmount()) <= 0) {
            throw new HmilyRuntimeException("???????????????");
        }
        final InventoryDO inventory = inventoryService.findByProductId(order.getProductId());

        if (inventory.getTotalInventory() < order.getCount()) {
            throw new HmilyRuntimeException("???????????????");
        }*/
        //??????????????????
        accountService.payment(buildAccountDTO(order));
        //????????????????????????
        inventoryService.decrease(buildInventoryDTO(order));
    }

    @Override
    public void testMakePayment(Order order) {
        updateOrderStatus(order, OrderStatusEnum.PAYING);
        //??????????????????
        accountService.testPayment(buildAccountDTO(order));
        //????????????????????????
        inventoryService.testDecrease(buildInventoryDTO(order));
    }

    /**
     * ????????????
     *
     * @param order ????????????
     */
    @Override
    @HmilyTCC(confirmMethod = "confirmOrderStatus", cancelMethod = "cancelOrderStatus")
    public void makePaymentWithNested(Order order) {
        updateOrderStatus(order, OrderStatusEnum.PAYING);
        final AccountDO accountDO = accountService.findByUserId(order.getUserId());
        if (accountDO.getBalance().compareTo(order.getTotalAmount()) <= 0) {
            throw new HmilyRuntimeException("???????????????");
        }
        //??????????????????
        accountService.paymentWithNested(buildAccountNestedDTO(order));
    }
    
    @Override
    @HmilyTCC(confirmMethod = "confirmOrderStatus", cancelMethod = "cancelOrderStatus")
    public void makePaymentWithNestedException(Order order) {
        updateOrderStatus(order, OrderStatusEnum.PAYING);
        final AccountDO accountDO = accountService.findByUserId(order.getUserId());
        if (accountDO.getBalance().compareTo(order.getTotalAmount()) <= 0) {
            throw new HmilyRuntimeException("???????????????");
        }
        //??????????????????
        accountService.paymentWithNestedException(buildAccountNestedDTO(order));
    }
    
    @Override
    @HmilyTCC(confirmMethod = "confirmOrderStatus", cancelMethod = "cancelOrderStatus")
    public String mockPaymentInventoryWithTryException(Order order) {
        updateOrderStatus(order, OrderStatusEnum.PAYING);
        //??????????????????
        accountService.payment(buildAccountDTO(order));
        inventoryService.mockWithTryException(buildInventoryDTO(order));
        return "success";
    }
    
    @Override
    @HmilyTCC(confirmMethod = "confirmOrderStatus", cancelMethod = "cancelOrderStatus")
    public String mockPaymentInventoryWithTryTimeout(Order order) {
        updateOrderStatus(order, OrderStatusEnum.PAYING);
        //??????????????????
        accountService.payment(buildAccountDTO(order));
        inventoryService.mockWithTryTimeout(buildInventoryDTO(order));
        return "success";
    }
    
    @Override
    @HmilyTCC(confirmMethod = "confirmOrderStatus", cancelMethod = "cancelOrderStatus")
    public String mockPaymentAccountWithTryException(Order order) {
        updateOrderStatus(order, OrderStatusEnum.PAYING);
        accountService.mockTryPaymentException(buildAccountDTO(order));
        return "success";
    }
    
    @Override
    @HmilyTCC(confirmMethod = "confirmOrderStatus", cancelMethod = "cancelOrderStatus")
    public String mockPaymentAccountWithTryTimeout(Order order) {
        updateOrderStatus(order, OrderStatusEnum.PAYING);
        accountService.mockTryPaymentTimeout(buildAccountDTO(order));
        return "success";
    }
    
    @Override
    @HmilyTCC(confirmMethod = "confirmOrderStatus", cancelMethod = "cancelOrderStatus")
    public String mockPaymentInventoryWithConfirmTimeout(Order order) {
        updateOrderStatus(order, OrderStatusEnum.PAYING);
        //??????????????????
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAmount(order.getTotalAmount());
        accountDTO.setUserId(order.getUserId());
        accountService.payment(accountDTO);
        inventoryService.mockWithConfirmTimeout(buildInventoryDTO(order));
        return "success";
    }
    
    public void confirmOrderStatus(Order order) {
        updateOrderStatus(order, OrderStatusEnum.PAY_SUCCESS);
        LOGGER.info("=========????????????confirm????????????================");
    }
    
    public void cancelOrderStatus(Order order) {
        updateOrderStatus(order, OrderStatusEnum.PAY_FAIL);
        LOGGER.info("=========????????????cancel????????????================");
    }
    
    private void updateOrderStatus(Order order, OrderStatusEnum orderStatus) {
        order.setStatus(orderStatus.getCode());
        orderMapper.update(order);
    }
    
    private AccountDTO buildAccountDTO(Order order) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAmount(order.getTotalAmount());
        accountDTO.setUserId(order.getUserId());
        return accountDTO;
    }
    
    private AccountNestedDTO buildAccountNestedDTO(Order order) {
        AccountNestedDTO nestedDTO = new AccountNestedDTO();
        nestedDTO.setAmount(order.getTotalAmount());
        nestedDTO.setUserId(order.getUserId());
        nestedDTO.setProductId(order.getProductId());
        nestedDTO.setCount(order.getCount());
        return nestedDTO;
    }
    
    private InventoryDTO buildInventoryDTO(Order order) {
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setCount(order.getCount());
        inventoryDTO.setProductId(order.getProductId());
        return inventoryDTO;
    }
}
