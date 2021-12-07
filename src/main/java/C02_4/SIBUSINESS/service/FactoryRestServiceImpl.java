package C02_4.SIBUSINESS.service;


import C02_4.SIBUSINESS.repository.ItemFactoryDB;
import C02_4.SIBUSINESS.rest.FactoryDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import javax.transaction.Transactional;
import C02_4.SIBUSINESS.rest.Setting;

@Service
@Transactional
public class FactoryRestServiceImpl implements FactoryRestService{
    private final WebClient webClient;

    public FactoryRestServiceImpl(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl(Setting.factoryUrl).build();
    }

    @Override
    public Mono<String> getMesin(){
        return this.webClient.get().uri("/rest/mesin").retrieve().bodyToMono(String.class);
    }
    @Override
    public void mesin() {
        Mono<FactoryDetail> uriWeb = this.webClient.get().uri("/rest/mesin").retrieve().bodyToMono(FactoryDetail.class);
        Integer idMesin = uriWeb.block().getIdMesin();
//        return uriWeb.block();

    }



}