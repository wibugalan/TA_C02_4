package C02_4.SIBUSINESS.repository;

import C02_4.SIBUSINESS.model.ItemFactoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemFactoryDB extends JpaRepository<ItemFactoryModel, Long> {
    List<ItemFactoryModel> findAllBystatus(Integer status);

}
