package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.rest.BaseResponse;
import C02_4.SIBUSINESS.rest.ItemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import reactor.core.publisher.Mono;

public interface ItemRestService {
    Mono<BaseResponse> createItem(ItemDTO item) throws JsonProcessingException;
}
