package com.slavamashkov.orderservice.dto;

import com.slavamashkov.orderservice.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsDto {
    private Long id;
    private String skuCode;
    private BigDecimal orderNumber;
    private Integer quantity;

    public static OrderLineItems mapFromDto(OrderLineItemsDto orderLineItemsDto) {
        return OrderLineItems.builder()
                .price(orderLineItemsDto.getOrderNumber())
                .quantity(orderLineItemsDto.getQuantity())
                .skuCode(orderLineItemsDto.skuCode)
                .build();
    }
}
