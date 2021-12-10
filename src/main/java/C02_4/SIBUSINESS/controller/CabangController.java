package C02_4.SIBUSINESS.controller;

import C02_4.SIBUSINESS.rest.CabangDetail;
import C02_4.SIBUSINESS.service.CabangRestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/cabang")
public class CabangController {
    @Autowired
    private CabangRestService cabangRestService;

    @GetMapping("/add")
    public String formAddCabang(
            Model model
    ){
        return "form-add-cabang";
    }

    @PostMapping("/add")
    public String addCabang(
            Model model,
            @RequestParam(value = "nama") String nama,
            @RequestParam(value = "alamat") String alamat,
            @RequestParam(value = "ukuran") Long ukuran,
            @RequestParam(value = "no_telp") String no_telp
    ){
        CabangDetail cabang = new CabangDetail();
        cabang.setNama(nama);
        cabang.setAlamat(alamat);
        cabang.setNoTelp(no_telp);
        cabang.setUkuran(ukuran);
        cabang.setStatus(Long.parseLong("0"));
        cabangRestService.postCabang(cabang);
        return "add-cabang";
    }
}
