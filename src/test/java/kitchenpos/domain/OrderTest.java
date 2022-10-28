package kitchenpos.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {

    private Long id = 1L;
private Long orderTableId = 11L;
    private OrderStatus orderStatus = OrderStatus.COOKING;
    private LocalDateTime orderedTime = LocalDateTime.now();
    private OrderLineItem orderLineItem = new OrderLineItem(1L, 1L, 3L);
    private List<OrderLineItem> orderLineItems = Arrays.asList(orderLineItem);

    @Test
    void order를_생성할_수_있다() {
        Order order = new Order(id, orderTableId, orderStatus, orderedTime, orderLineItems);

        Assertions.assertAll(
                () -> assertThat(order.getId()).isEqualTo(id),
                () -> assertThat(order.getOrderTableId()).isEqualTo(orderTableId),
                () -> assertThat(order.getOrderStatus()).isEqualTo(orderStatus),
                () -> assertThat(order.getOrderedTime()).isEqualTo(orderedTime),
                () -> assertThat(order.getOrderLineItems()).isEqualTo(orderLineItems)
        );
    }

    @Test
    void order_line_items가_비어있으면_예외를_반환한다() {
        List<OrderLineItem> emptyOrderLineItems = new ArrayList<>();
        assertThatThrownBy(() -> new Order(id, orderTableId, orderStatus, orderedTime, emptyOrderLineItems))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void order_상태를_바꿀_수_있다() {
        Order order = new Order(id, orderTableId, orderStatus, orderedTime, orderLineItems);
        OrderStatus completion = OrderStatus.COMPLETION;
        order.changeOrderStatus(completion);

        Assertions.assertAll(
                () -> assertThat(order.getOrderStatus()).isNotEqualTo(orderStatus),
                () -> assertThat(order.getOrderStatus()).isEqualTo(completion)
        );
    }

    @Test
    void 상태를_바꿀_때_완료_상태이면_예외를_던진다() {
        OrderStatus completion = OrderStatus.COMPLETION;
        Order order = new Order(id, orderTableId, completion, orderedTime, orderLineItems);
        assertThatThrownBy(() -> order.changeOrderStatus(OrderStatus.COOKING))
                .isInstanceOf(IllegalArgumentException.class);
    }
}