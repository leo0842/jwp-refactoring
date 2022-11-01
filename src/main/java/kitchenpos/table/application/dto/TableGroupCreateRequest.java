package kitchenpos.table.application.dto;

import java.util.List;
import kitchenpos.table.domain.TableGroup;

public class TableGroupCreateRequest {

    private List<OrderTableIdDto> orderTables;

    public TableGroupCreateRequest() {
    }

    public TableGroupCreateRequest(final List<OrderTableIdDto> orderTables) {
        this.orderTables = orderTables;
    }

    public TableGroup toTableGroup() {
        return new TableGroup();
    }

    public List<OrderTableIdDto> getOrderTables() {
        return orderTables;
    }
}