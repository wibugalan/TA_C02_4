package C02_4.SIBUSINESS.repository;
import C02_4.SIBUSINESS.model.ItemFactoryModel;
import C02_4.SIBUSINESS.model.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDB extends JpaRepository<ItemModel, Long>{
}
