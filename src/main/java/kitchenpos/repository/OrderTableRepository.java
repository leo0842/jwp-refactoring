package kitchenpos.repository;

import java.util.Collection;
import kitchenpos.domain.OrderTable;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface OrderTableRepository extends Repository<OrderTable, Long> {

    OrderTable save(OrderTable entity);

    Optional<OrderTable> findById(Long id);

    List<OrderTable> findAll();

    List<OrderTable> findAllByIdIn(List<Long> ids);

    List<OrderTable> findAllByTableGroupId(Long tableGroupId);

    @Query("SELECT ot FROM OrderTable ot WHERE ot.id IN :ids")
    List<OrderTable> findAllByOrderTableIdsIn(@Param("ids") List<Long> orderTableIds);

    void saveAll(Iterable<OrderTable> orderTables);
}
