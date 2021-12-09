package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.model.ItemFactoryModel;
import C02_4.SIBUSINESS.rest.FactoryDetail;
import C02_4.SIBUSINESS.rest.ItemDetail;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ItemFactoryRestService {
    ItemFactoryModel createItem(ItemFactoryModel item);
    List<ItemDetail> item() throws JsonProcessingException;

}
