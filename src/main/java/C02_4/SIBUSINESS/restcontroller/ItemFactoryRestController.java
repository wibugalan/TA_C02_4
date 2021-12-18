package C02_4.SIBUSINESS.restcontroller;

import C02_4.SIBUSINESS.model.ItemFactoryModel;
import C02_4.SIBUSINESS.rest.BaseResponse;
import C02_4.SIBUSINESS.service.ItemFactoryRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;



import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/item")
public class ItemFactoryRestController {

    @Autowired
    ItemFactoryRestService itemFactoryRestService;

    @PostMapping(value="")
    private BaseResponse createItem(@Valid @RequestBody ItemFactoryModel item, BindingResult bindingResult) throws ParseException{
        BaseResponse response = new BaseResponse();
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field."
            );
        }else{
            try{
                item.setStatus(0);
                ItemFactoryModel hasil = itemFactoryRestService.createItem(item);
                response.setStatus(200);
                response.setMessage("success");
                response.setResult(hasil);

            } catch (Exception e){
                response.setStatus(400);
                response.setMessage(e.toString());
                response.setResult(null);
            }
        }
        return response;
    }
}

