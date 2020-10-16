package apap.tutorial.traveloke.controller;


import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.PostLoad;
import java.util.List;

@Controller
public class KamarController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    public List<KamarModel> tempKamar;

    @GetMapping("/kamar/add/{idHotel}")
    private String addKamarFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        hotel.setListKamar(tempKamar);
        hotel.getListKamar().add(new KamarModel());
        model.addAttribute("hotel", hotel);
        model.addAttribute("page", "Add Kamar");
        return "form-add-kamar";

    }

    @PostMapping("/kamar/add/{idHotel}")
    private String addRow(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        model.addAttribute("tempKamar", tempKamar);
        return "form-add-kamar";
    }

    @PostMapping("/kamar/add")
    private String addKamarSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        kamarService.addKamar(kamar);
        model.addAttribute("kamar", kamar);
        return "add-kamar";
    }

    @GetMapping("/kamar/change/{noKamar}")
    public String changeHotelFormPage(
            @PathVariable Long noKamar,
            Model model
    ){
        KamarModel kamar = kamarService.getKamarByNoKamar(noKamar);
        model.addAttribute("kamar", kamar);
        model.addAttribute("page", "Change Data Kamar");
        return "form-update-kamar";
    }

    @PostMapping("/kamar/change")
    public String changeHotelFormSubmit(
            @ModelAttribute KamarModel kamar,
            Model model
    ){
        KamarModel kamarUpdated = kamarService.updateKamar(kamar);
        model.addAttribute("kamar", kamar);
        return "update-kamar";
    }

    @PostMapping(path = "/kamar/delete")
    public String deleteKamarFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        model.addAttribute("kamarCount", hotel.getListKamar().size());
        for(KamarModel kamar: hotel.getListKamar()){
            kamarService.deleteKamar(kamar);
        }
        return "delete-kamar";
    }
}

//    @GetMapping(value = "kamar/delete/{noKamar}")
//    public String deleteHotelWithPathVariable(
//            @PathVariable(value = "noKamar") Long noKamar,
//            Model model
//    ){
//        // Menghapus Hotel sesuai dengan nomor kamar
//        KamarModel kamar = kamarService.deleteKamar(noKamar);
//
//        model.addAttribute("id", noKamar);
//        model.addAttribute("kamar", kamar);
//        return "delete-kamar";
//    }