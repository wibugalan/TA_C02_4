package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.rest.FactoryDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FactoryRestService {

    List<FactoryDetail> mesin() throws JsonProcessingException;
}


