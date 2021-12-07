package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.rest.FactoryDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.json.JSONArray;
//import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import javax.transaction.Transactional;
import C02_4.SIBUSINESS.rest.Setting;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FactoryRestServiceImpl implements FactoryRestService{
    private final WebClient webClient;

    public FactoryRestServiceImpl(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl(Setting.factoryUrl).build();
    }

    // hasilnya json
    @Override
    public Flux<FactoryDetail> getMesinJson(){
        return this.webClient.get().uri("/rest/mesin").retrieve().bodyToFlux(FactoryDetail.class);
    }

    // hasilnya html
    @Override
    public Mono<String> getMesinJson2(){
        return this.webClient.get().uri("/rest/mesin").retrieve().bodyToMono(String.class);
    }


    @Override
    public void mesin() {
        Flux<String> uriWeb = this.webClient.get().uri("/rest/mesin").retrieve().bodyToFlux(String.class);

        String jsonStr = uriWeb.toString();
        ObjectMapper mapper = new ObjectMapper();
        FactoryDetail[] jsonObj = new FactoryDetail[0];
        try {
            jsonObj = mapper.readValue(jsonStr, FactoryDetail[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        for (FactoryDetail itr : jsonObj) {
            System.out.println("Val of name is: " + itr.getNama());
            System.out.println("Val of number is: " + itr.getIdKategori());
        }


    }

//    @Override
//    public List<FactoryDetail> getMesinJson() throws Exception {
//        List<FactoryDetail> allPlants = new ArrayList<FactoryDetail>();
//        Flux<FactoryDetail> uriWeb = this.webClient.get().uri("/rest/mesin").retrieve().bodyToFlux(FactoryDetail.class);
//        String rawJson = uriWeb.toString();
//        JSONObject root = new JSONObject(rawJson);
//        JSONArray plants = root.getJSONArray("JSON");
//
//        for(int i =0; i < plants.length(); i++){
//            JSONObject jsonPlant = plants.getJSONObject(i);
//            FactoryDetail plant = new FactoryDetail();
//            int guid = jsonPlant.getInt("id_mesin");
//            plant.setIdMesin(guid);
//            allPlants.add(plant);
//        }
//
//
//        return allPlants;
//
//
//
//    }



}