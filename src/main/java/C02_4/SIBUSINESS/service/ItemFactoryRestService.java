package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.model.ItemFactoryModel;
import C02_4.SIBUSINESS.rest.FactoryDetail;
import C02_4.SIBUSINESS.rest.ItemDetail;
import C02_4.SIBUSINESS.rest.ResultItemDetail;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface ItemFactoryRestService {
    ItemFactoryModel createItem(ItemFactoryModel item);
    List<ResultItemDetail> item() throws JsonProcessingException;
    ResultItemDetail detailItem(String uuid) throws JsonProcessingException;

}
