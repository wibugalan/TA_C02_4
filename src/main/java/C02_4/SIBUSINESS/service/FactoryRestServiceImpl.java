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
import java.util.Date;
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
    public List<FactoryDetail> mesin() throws JsonProcessingException {
        Mono<String> uriWeb = this.webClient.get().uri("/rest/mesin").retrieve().bodyToMono(String.class);
        List<FactoryDetail> allPlants = new ArrayList<FactoryDetail>();
        ObjectMapper mapper = new ObjectMapper();
        FactoryDetail[] jsonObj = mapper.readValue(uriWeb.block(), FactoryDetail[].class);

        for (FactoryDetail itr : jsonObj) {
            int id = itr.getIdMesin();
            itr.setIdMesin(id);

            String nama = itr.getNama();
            itr.setNama(nama);

            int kategori = itr.getIdKategori();
            itr.setIdKategori(kategori);

            Date tanggal = itr.getTanggalDibuat();
            itr.setTanggalDibuat(tanggal);

            int kapasitas = itr.getKapasitas();
            itr.setKapasitas(kapasitas);

            allPlants.add(itr);
            System.out.println(nama);
        }
        return allPlants;


    }

//    @Override
//    public List<FactoryDetail> getListMesin() throws Exception {
//        List<FactoryDetail> allPlants = new ArrayList<FactoryDetail>();
//        Mono<String> uriWeb = this.webClient.get().uri("/rest/mesin").retrieve().bodyToMono(String.class);
//
//        String rawJson = uriWeb.toString();
//
//        for(FactoryDetail x : response.getQuote()){
//            JSONObject jsonPlant = plants.getJSONObject(i);
//            FactoryDetail plant = new FactoryDetail();
//            int guid = jsonPlant.getInt("id_mesin");
//            plant.setIdMesin(guid);
//            allPlants.add(plant);
//        }
//        return allPlants;
//
//    }



}