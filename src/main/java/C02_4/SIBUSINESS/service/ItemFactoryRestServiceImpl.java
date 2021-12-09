package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.model.ItemFactoryModel;
import C02_4.SIBUSINESS.repository.ItemFactoryDB;
import C02_4.SIBUSINESS.rest.FactoryDetail;
import C02_4.SIBUSINESS.rest.ItemDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import javax.transaction.Transactional;
import C02_4.SIBUSINESS.rest.Setting;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ItemFactoryRestServiceImpl implements ItemFactoryRestService{
    private final WebClient webClient;

    @Autowired
    private ItemFactoryDB itemFactoryDB;

    public ItemFactoryRestServiceImpl(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("https://si-item.herokuapp.com").build();
    }

    @Override
    public ItemFactoryModel createItem(ItemFactoryModel item){

        return itemFactoryDB.save(item);
    }

    @Override
    public List<ItemDetail> item() throws JsonProcessingException {
        Mono<String> uriWeb = this.webClient.get().uri("/api/item").retrieve().bodyToMono(String.class);
        List<ItemDetail> allPlants = new ArrayList<ItemDetail>();
        ObjectMapper mapper = new ObjectMapper();

        ItemDetail jsonObj = mapper.readValue(uriWeb.block(), ItemDetail.class);

        System.out.println(jsonObj.getStatus());
        System.out.println(jsonObj.getMessage());
        System.out.println(jsonObj.getResult());

//        for (ItemDetail itr : jsonObj) {
//            Integer status = itr.getStatus();
//            itr.setStatus(status);
//            allPlants.add(itr);
//            System.out.println(status);
//        }
        return allPlants;



    }








}