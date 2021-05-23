package com.mark.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Order implements Serializable {
    @TableId
    private BigInteger order_id;
    private int product_id;
    private int shop_id;
    private int uid;
    private int nums;
    private double sale_price;
    private double origin_price;
    private String discount;
    private boolean is_payed;
    private String address;
    private String phone;
    private String username;
    private String province;
    private String city;
    private String area;

    @Override
    public String toString() {
        return "Order [order_id=" + order_id + ", shop_id=" + shop_id + ", product_id=" + product_id + "]";
    }

}
