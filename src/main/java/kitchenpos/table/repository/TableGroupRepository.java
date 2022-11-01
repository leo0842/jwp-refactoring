package kitchenpos.table.repository;

import java.util.List;
import java.util.Optional;
import kitchenpos.table.domain.TableGroup;
import org.springframework.data.repository.Repository;

public interface TableGroupRepository extends Repository<TableGroup, Long> {

    TableGroup save(TableGroup entity);

    Optional<TableGroup> findById(Long id);

    List<TableGroup> findAll();
}