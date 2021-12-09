package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.model.ItemFactoryModel;
import C02_4.SIBUSINESS.repository.ItemFactoryDB;
import C02_4.SIBUSINESS.rest.ItemDetail;
import C02_4.SIBUSINESS.rest.ResultItemDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;

import reactor.core.publisher.Mono;

import java.util.ArrayList;
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
    public List<ResultItemDetail> item() throws JsonProcessingException {
        Mono<String> uriWeb = this.webClient.get().uri("/api/item").retrieve().bodyToMono(String.class);
        List<ResultItemDetail> allPlants = new ArrayList<ResultItemDetail>();
        ObjectMapper mapper = new ObjectMapper();

        ItemDetail jsonObj = mapper.readValue(uriWeb.block(), ItemDetail.class);
        ResultItemDetail[] jsonObj2 = mapper.readValue(jsonObj.getResult().toString(), ResultItemDetail[].class);

        for (ResultItemDetail itr : jsonObj2) {
            String uuid = itr.getUuid();
            itr.setUuid(uuid);

            String nama = itr.getNama();
            itr.setNama(nama);

            Integer harga = itr.getHarga();
            itr.setHarga(harga);

            Integer stok = itr.getStok();
            itr.setStok(stok);

            String kategori = itr.getKategori();
            itr.setKategori(kategori);

            allPlants.add(itr);
        }
        return allPlants;



    }








}