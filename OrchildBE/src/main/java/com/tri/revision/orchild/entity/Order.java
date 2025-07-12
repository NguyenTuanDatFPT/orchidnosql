package com.tri.revision.orchild.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tri.revision.orchild.enums.OrderStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    @Id
    private String id;

    private String userId; // Reference to User

    private BigDecimal totalAmount;

    private OrderStatus status;

    private String shippingAddress;
    private String phoneNumber;
    private String notes;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private List<String> orderItemIds; // List of OrderItem IDs
}
