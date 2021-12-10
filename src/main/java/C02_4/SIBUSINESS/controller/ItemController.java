package C02_4.SIBUSINESS.controller;

import C02_4.SIBUSINESS.model.ItemFactoryModel;
import C02_4.SIBUSINESS.model.UserModel;
import C02_4.SIBUSINESS.repository.ItemFactoryDB;
import C02_4.SIBUSINESS.repository.UserDB;
import C02_4.SIBUSINESS.rest.ItemDTO;
import C02_4.SIBUSINESS.service.ItemFactoryService;
import C02_4.SIBUSINESS.service.ItemRestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        ItemFactoryModel itemFactory = itemFactoryDB.getById(id);
        UserModel user = userDB.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        itemFactory.setApprover(user);
        itemFactory.setStatus(1);
        itemFactory.setStatus(2);
        itemFactoryService.updateItem(itemFactory);
        return "request-reject";
    }


}
