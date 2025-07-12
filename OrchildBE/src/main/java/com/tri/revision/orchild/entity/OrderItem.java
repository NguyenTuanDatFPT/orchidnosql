package com.tri.revision.orchild.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "order_items")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItem {
    @Id
    private String id;

    private String orderId; // Reference to Order
    private String orchidId; // Reference to Orchid

    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
}
