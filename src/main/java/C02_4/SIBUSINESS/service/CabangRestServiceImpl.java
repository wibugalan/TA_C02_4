package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.rest.CabangDetail;
import io.netty.handler.codec.Headers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class CabangRestServiceImpl implements CabangRestService{
    private final WebClient webClient;

    public CabangRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://siretail-6.herokuapp.com").build();
    }

    @Override
    public Mono<CabangDetail> postCabang(CabangDetail cabang) {
        Map body = new HashMap();
        body.put("nama", cabang.getNama());
        body.put("alamat", cabang.getAlamat());
        body.put("noTelp", cabang.getNoTelp());
        body.put("ukuran", cabang.getUkuran());
        body.put("status", cabang.getStatus());

        ResponseSpec start = webClient.post().uri("/api/cabang").bodyValue(body).retrieve();
        Mono<String> x = start.bodyToMono(String.class);

        System.out.println(x.block()+ "test");
        return  start.bodyToMono(CabangDetail.class);
    }

}
