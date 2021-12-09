package C02_4.SIBUSINESS.service;


import C02_4.SIBUSINESS.model.ItemFactoryModel;
import C02_4.SIBUSINESS.repository.ItemFactoryDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemFactoryServiceImpl implements ItemFactoryService{

    @Autowired
    ItemFactoryDB itemFactoryDB;

    @Override
    public List<ItemFactoryModel> getItemRequestList(){ return itemFactoryDB.findAllBystatus(0);}

    @Override
    public void deleteItem (ItemFactoryModel item){
        itemFactoryDB.delete(item);
    }

    @Override
    public ItemFactoryModel updateItem(ItemFactoryModel item){
        return itemFactoryDB.save(item);
    }
}
