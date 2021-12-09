package C02_4.SIBUSINESS.service;
import C02_4.SIBUSINESS.rest.BaseResponse;
import C02_4.SIBUSINESS.rest.ItemDTO;
import C02_4.SIBUSINESS.rest.Setting;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
public class ItemRestServiceImpl implements ItemRestService  {

    private final WebClient webClient;

    public ItemRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.ItemUrl).build();
    }

    @Override
    public Mono<BaseResponse> createItem(ItemDTO item) throws JsonProcessingException {
//        ObjectMapper map = new ObjectMapper();
//        String value = map.writeValueAsString(item);
//        System.out.println(item.getKategori());
//        System.out.println(item.getHarga());
//        System.out.println(item.getNama());
//        System.out.println(item.getStok());
//        System.out.println("INI TUTUP DEBUG");
        Mono<BaseResponse> responseMono = this.webClient
                .post()
                .uri("api/item")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(item), ItemDTO.class)
                .retrieve()
                .bodyToMono(BaseResponse.class);
        System.out.println(responseMono.block().getStatus());
        return responseMono;
    }
}
