package C02_4.SIBUSINESS.service;


import C02_4.SIBUSINESS.model.ItemFactoryModel;
import C02_4.SIBUSINESS.repository.ItemFactoryDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;

@Service
@Transactional
public class ItemFactoryRestServiceImpl implements ItemFactoryRestService{

    @Autowired
    private ItemFactoryDB itemFactoryDB;

    @Override
    public ItemFactoryModel createItem(ItemFactoryModel item){
        return itemFactoryDB.save(item);
    }



}
