package C02_4.SIBUSINESS.controller;

//import apap.tutorial.cineplux.model.PenjagaModel;
import C02_4.SIBUSINESS.model.ItemFactoryModel;
import C02_4.SIBUSINESS.rest.FactoryDetail;
import C02_4.SIBUSINESS.service.FactoryRestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/api/v1")
public class FactoryController {

    @Autowired
    private FactoryRestService factoryRestService;

// hasilnya json
//    @GetMapping("/mesin")
//    public Flux<FactoryDetail> listMesin(Model model){
//        Flux<FactoryDetail> listMesin = factoryRestService.getMesinJson();
//        return listMesin;
//    }

////    hasilnya html
//    @GetMapping("/mesin")
//    public String listMesin(Model model){
//        Mono<String> listMesin2 = factoryRestService.getMesinJson2();
//        String listMesin = listMesin2.block();
//        model.addAttribute("listMesin", listMesin);
//        return "viewall-mesin";
//    }

    @GetMapping("/mesin")
    public String listMesin(Model model) throws JsonProcessingException {
        List<FactoryDetail> listMesin = factoryRestService.mesin();
        model.addAttribute("listMesin", listMesin);
        return "viewall-mesin";
    }


}