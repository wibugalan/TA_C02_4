package C02_4.SIBUSINESS.repository;


import C02_4.SIBUSINESS.model.CouponModel;
import C02_4.SIBUSINESS.model.ItemFactoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CouponDB extends JpaRepository<CouponModel, Long> {
    List<CouponModel> findAll();
    List<CouponModel> findAllByStatus(boolean status);
}
