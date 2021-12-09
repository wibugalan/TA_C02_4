package C02_4.SIBUSINESS.service;

import C02_4.SIBUSINESS.rest.CabangDetail;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
public class CabangRestServiceImpl implements CabangRestService{
    private final WebClient webClient;

    public CabangRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("siretail-6.herokuapp.com").build();
    }

    @Override
    public Mono<CabangDetail> postCabang(CabangDetail cabang) {
        MultiValueMap<String, String> bodyRequest = new LinkedMultiValueMap<>();
        bodyRequest.add("nama", cabang.getNama());
        bodyRequest.add("alamat", cabang.getAlamat());
        bodyRequest.add("ukuran", Long.toString(cabang.getUkuran()));
        bodyRequest.add("noTelp", cabang.getNoTelp());
        bodyRequest.add("status", Long.toString(cabang.getStatus()));

        WebClient.ResponseSpec start = webClient.post().uri("/api/cabang").bodyValue(bodyRequest).retrieve();
        return  start.bodyToMono(CabangDetail.class);
    }
}
