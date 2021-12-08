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
        }
        return allPlants;


    }



}