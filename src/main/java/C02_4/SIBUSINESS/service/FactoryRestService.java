package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.rest.FactoryDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FactoryRestService {
    // hasilnya json
    Flux<FactoryDetail> getMesinJson();

    // hasilnya html
    Mono<String> getMesinJson2();

    List<FactoryDetail> mesin() throws JsonProcessingException;
}


