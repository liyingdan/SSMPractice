package com.lyd.mapper;

import com.lyd.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    /*查询所有的订单*/
    public List<Order> getAllOrders();
    /*根据id查询订单*/
    public Order getOrderWithId(Integer id);
    /*保存订单*/
    public void insertOrder(Order order);
    /*根据cust_id查询订单*/
    public Order getOrderWithCustId(Integer id);

    /*更新订单OderId*/
    public void updateOrderId(@Param("cust_id") Integer cust_id, @Param("order_id") Integer order_id);
}
