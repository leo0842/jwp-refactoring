package kitchenpos.application.dto.request;

public class OrderChangeRequest {

    private String orderStatus;

    public OrderChangeRequest() {
    }

    public OrderChangeRequest(final String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
