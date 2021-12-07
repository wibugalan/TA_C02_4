package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.rest.FactoryDetail;
import reactor.core.publisher.Mono;
import java.util.List;

public interface FactoryRestService {
    Mono<String> getMesin();
    void mesin();

}


