package C02_4.SIBUSINESS.repository;

import C02_4.SIBUSINESS.model.CouponTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouponTypeDB extends JpaRepository<CouponTypeModel, Long> {
    List<CouponTypeModel> findAll();
}
