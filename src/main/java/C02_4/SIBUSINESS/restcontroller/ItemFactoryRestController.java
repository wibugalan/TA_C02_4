package C02_4.SIBUSINESS.restcontroller;

import C02_4.SIBUSINESS.model.ItemFactoryModel;
import C02_4.SIBUSINESS.service.ItemFactoryRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;



import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/item")
public class ItemFactoryRestController {

    @Autowired
    ItemFactoryRestService itemFactoryRestService;

    @PostMapping(value="")
    private ItemFactoryModel createItem(@Valid @RequestBody ItemFactoryModel item, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field."
            );
        }else{
            item.setCluster("C02");
            item.setStatus(0);
            return itemFactoryRestService.createItem(item);
        }
    }
}
