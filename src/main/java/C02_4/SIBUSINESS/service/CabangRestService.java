package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.rest.CabangDetail;
import reactor.core.publisher.Mono;

public interface CabangRestService {
    Mono<CabangDetail> postCabang(CabangDetail cabang);
}
