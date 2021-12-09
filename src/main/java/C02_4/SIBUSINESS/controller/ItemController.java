package C02_4.SIBUSINESS.controller;

import C02_4.SIBUSINESS.model.ItemFactoryModel;
import C02_4.SIBUSINESS.model.ItemModel;
import C02_4.SIBUSINESS.model.UserModel;
import C02_4.SIBUSINESS.repository.ItemFactoryDB;
import C02_4.SIBUSINESS.repository.UserDB;
import C02_4.SIBUSINESS.rest.BaseResponse;
import C02_4.SIBUSINESS.rest.ItemDTO;
import C02_4.SIBUSINESS.service.ItemFactoryService;
import C02_4.SIBUSINESS.service.ItemRestService;
import C02_4.SIBUSINESS.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import javax.validation.Valid;
import java.text.ParseException;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRestService itemRestService;

    @Autowired
    private UserDB userDB;

    @Autowired
    private ItemFactoryDB itemFactoryDB ;

    @Autowired
    private ItemFactoryService itemFactoryService ;

//    @PostMapping(value = "")
//    private BaseResponse<ItemModel> addItem(
//            @Valid @RequestBody ItemDTO item,
//            BindingResult bindingResult) throws ParseException {
//        BaseResponse<ItemModel> response = new BaseResponse<>();
//        if (bindingResult.hasFieldErrors()) {
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, "Request Body has invalid type or missing field");
//        } else {
//            try {
//                ItemModel newItem = itemRestService.createItem(item);
//                response.setStatus(201);
//                response.setMessage("created");
//                response.setResult(newItem);
//            } catch (Exception e) {
//                response.setStatus(400);
//                response.setMessage(e.toString());
//                response.setResult(null);
//            }
//            return response;
//        }
//    }

    @GetMapping(value="/requested/accept/{id}")
    public String requestAccept(Model model, @PathVariable Long id
                                ) throws JsonProcessingException {

        UserModel user = userDB.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        ItemFactoryModel itemFactory = itemFactoryDB.getById(id);
        itemFactory.setApprover(user);
        itemFactory.setStatus(1);

        ItemDTO item = new ItemDTO();
        item.setStok(itemFactory.getStock());
        item.setKategori(itemFactory.getCategory());
        item.setHarga(itemFactory.getPrice());
        item.setNama(itemFactory.getName());
        itemRestService.createItem(item);
        return "request-accept";
    }

    @GetMapping(value="/requested/reject/{id}")
    public String requestReject(Model model, @PathVariable Long id
    ) throws JsonEOFException {
        System.out.println("Masuk Reject Bos");
        ItemFactoryModel itemFactory = itemFactoryDB.getById(id);
        itemFactory.setStatus(2);
        itemFactoryService.updateItem(itemFactory);
//        itemFactoryService.deleteItem(itemFactory);
        return "request-reject";
    }


}
