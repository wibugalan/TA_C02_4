package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.rest.FactoryDetail;
import C02_4.SIBUSINESS.rest.ItemDetail;
import C02_4.SIBUSINESS.rest.ResultItemDetail;
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

    @Override
    public List<FactoryDetail> mesin() throws JsonProcessingException {
        Mono<String> uriWeb = this.webClient.get().uri("/api/list-mesin").retrieve().bodyToMono(String.class);
        List<FactoryDetail> allPlants = new ArrayList<FactoryDetail>();
        ObjectMapper mapper = new ObjectMapper();

        ItemDetail jsonObj2 = mapper.readValue(uriWeb.block(), ItemDetail.class);
        FactoryDetail[] jsonObj = mapper.readValue(jsonObj2.getResult().toString(), FactoryDetail[].class);


        for (FactoryDetail itr : jsonObj) {
            int id = itr.getIdMesin();
            itr.setIdMesin(id);

            String nama = itr.getNama();
            itr.setNama(nama);

            Integer kategori = itr.getIdKategori();
            itr.setIdKategori(kategori);

            Date tanggal = itr.getTanggalDibuat();
            itr.setTanggalDibuat(tanggal);

            int kapasitas = itr.getKapasitas();
            itr.setKapasitas(kapasitas);

            allPlants.add(itr);
        }
        return allPlants;


    }


    @Override
    public List<FactoryDetail> filterMesin(Long idKategori) throws JsonProcessingException {
        Mono<String> uriWeb = this.webClient.get().uri("/api/list-mesin").retrieve().bodyToMono(String.class);
        List<FactoryDetail> allPlants = new ArrayList<FactoryDetail>();
        ObjectMapper mapper = new ObjectMapper();
        ItemDetail jsonObj2 = mapper.readValue(uriWeb.block(), ItemDetail.class);
        FactoryDetail[] jsonObj = mapper.readValue(jsonObj2.getResult().toString(), FactoryDetail[].class);


        String x = idKategori.toString();

        for (FactoryDetail itr : jsonObj) {
            if (itr.getIdKategori().toString().equals(x)){
                allPlants.add(itr);
            }
        }

        return allPlants;
    }



}