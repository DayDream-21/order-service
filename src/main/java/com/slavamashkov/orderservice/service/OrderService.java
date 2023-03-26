package com.slavamashkov.orderservice.service;

import com.slavamashkov.orderservice.dto.OrderRequest;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
