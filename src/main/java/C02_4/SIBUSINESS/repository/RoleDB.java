package C02_4.SIBUSINESS.repository;

import C02_4.SIBUSINESS.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDB extends JpaRepository<RoleModel, Long> {
}
