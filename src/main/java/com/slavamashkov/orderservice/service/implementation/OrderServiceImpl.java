package com.slavamashkov.orderservice.service.implementation;

import com.slavamashkov.orderservice.dto.OrderLineItemsDto;
import com.slavamashkov.orderservice.dto.OrderRequest;
import com.slavamashkov.orderservice.model.Order;
import com.slavamashkov.orderservice.model.OrderLineItems;
import com.slavamashkov.orderservice.repository.OrderRepository;
import com.slavamashkov.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(OrderLineItemsDto::mapFromDto)
                .toList();

        order.setOrderLineItems(orderLineItems);

        orderRepository.save(order);

        log.info("Product with id: {} is saved", order.getId());
    }
}
