package com.tri.revision.orchild.mapper;

import com.tri.revision.orchild.dto.request.OrderCreationRequest;
import com.tri.revision.orchild.dto.request.OrderItemRequest;
import com.tri.revision.orchild.dto.response.OrderItemResponse;
import com.tri.revision.orchild.dto.response.OrderResponse;
import com.tri.revision.orchild.entity.Order;
import com.tri.revision.orchild.entity.OrderItem;
import com.tri.revision.orchild.entity.Orchid;
import com.tri.revision.orchild.entity.User;
import com.tri.revision.orchild.enums.OrderStatus;
import com.tri.revision.orchild.repository.OrderItemRepository;
import com.tri.revision.orchild.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    /**
     * Convert OrderCreationRequest to Order entity
     */
    public Order toOrder(OrderCreationRequest request, User user, BigDecimal totalAmount) {
        if (request == null) {
            return null;
        }
        return Order.builder()
                .userId(user != null ? user.getId() : null)
                .totalAmount(totalAmount)
                .status(OrderStatus.PENDING)
                .shippingAddress(request.shippingAddress())
                .phoneNumber(request.phoneNumber())
                .notes(request.notes())
                .createAt(LocalDateTime.now())
                .build();
    }

    /**
     * Convert OrderItemRequest to OrderItem entity
     */
    public OrderItem toOrderItem(OrderItemRequest request, Order order, Orchid orchid) {
        if (request == null || order == null || orchid == null) {
            return null;
        }
        BigDecimal unitPrice = orchid.getPrice();
        BigDecimal totalPrice = unitPrice.multiply(BigDecimal.valueOf(request.quantity()));
        return OrderItem.builder()
                .orderId(order.getId())
                .orchidId(orchid.getId())
                .quantity(request.quantity())
                .unitPrice(unitPrice)
                .totalPrice(totalPrice)
                .build();
    }

    /**
     * Convert Order entity to OrderResponse
     */
    public OrderResponse toOrderResponse(Order order) {
        if (order == null) {
            return null;
        }
        // Fetch user by userId
        final String[] username = {null};
        if (order.getUserId() != null) {
            userRepository.findById(order.getUserId()).ifPresent(u -> username[0] = u.getUsername());
        }
        // Fetch order items by orderItemIds
        List<OrderItemResponse> orderItemResponses = order.getOrderItemIds() != null
            ? orderItemRepository.findAllById(order.getOrderItemIds()).stream()
                .map(this::toOrderItemResponse)
                .collect(Collectors.toList())
            : List.of();
        return new OrderResponse(
                order.getId(),
                order.getUserId(),
                username[0],
                order.getTotalAmount(),
                order.getStatus(),
                order.getShippingAddress(),
                order.getPhoneNumber(),
                order.getNotes(),
                order.getCreateAt(),
                order.getUpdateAt(),
                orderItemResponses
        );
    }

    /**
     * Convert OrderItem entity to OrderItemResponse
     */
    public OrderItemResponse toOrderItemResponse(OrderItem orderItem) {
        if (orderItem == null) {
            return null;
        }
        // Fetch orchid by orchidId
        String orchidName = null;
        String orchidImageUrl = null;
        if (orderItem.getOrchidId() != null) {
            // You may want to inject OrchidRepository and fetch orchid here if needed
        }
        return new OrderItemResponse(
                orderItem.getId(),
                orderItem.getOrchidId(),
                orchidName,
                orchidImageUrl,
                orderItem.getQuantity(),
                orderItem.getUnitPrice(),
                orderItem.getTotalPrice()
        );
    }
}
