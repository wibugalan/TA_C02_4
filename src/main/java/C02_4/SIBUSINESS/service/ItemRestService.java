package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.model.ItemModel;
import C02_4.SIBUSINESS.rest.BaseResponse;
import C02_4.SIBUSINESS.rest.ItemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ItemRestService {
    Mono<BaseResponse> createItem(ItemDTO item) throws JsonProcessingException;
}
