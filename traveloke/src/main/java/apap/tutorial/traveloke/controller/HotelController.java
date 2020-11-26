package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
public class HotelController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/hotel/add")
    public String addHotelFormPage(Model model){
        model.addAttribute("hotel", new HotelModel());
        model.addAttribute("page", "Add Hotel");
        return "form-add-hotel";
    }

    @PostMapping("/hotel/add")
    public String addHotelSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        hotelService.addHotel(hotel);
        model.addAttribute("idHotel", hotel.getId());
        return "add-hotel";
    }

    @GetMapping("/hotel/change/{idHotel}")
    public String changeHotelFormPage(
            @PathVariable Long idHotel,
            Model model
    ){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        model.addAttribute("hotel", hotel);
        model.addAttribute("page", "Change Data Hotel");
        return "form-update-hotel";
    }

    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(
            @ModelAttribute HotelModel hotel,
            Model model
    ){
        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
        model.addAttribute("hotel", hotel);
        return "update-hotel";
    }

    @GetMapping("/hotel/view")
    public String viewDetailHotelRequestParam(
            @RequestParam(value = "idHotel") Long idHotel,
            Model model
    ){
            HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
            List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
            Integer size = listKamar.size();

            model.addAttribute("hotel", hotel);
            model.addAttribute("size", size);
            model.addAttribute("listKamar", listKamar);
            model.addAttribute("page", "View Hotel");

            return "view-hotel";
    }

    @GetMapping("/hotel/view/{idHotel}")
    public String viewDetailHotelPathVariable(
            @PathVariable(value = "idHotel") Long idHotel,
            Model model
    ){
            HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
            List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
            Integer size = listKamar.size();

            model.addAttribute("hotel", hotel);
            model.addAttribute("size", size);
            model.addAttribute("listKamar", listKamar);
            model.addAttribute("page", "View Hotel");
            return "view-hotel";
    }

    @GetMapping(value = "hotel/delete/{idHotel}")
    public String deleteHotelWithPathVariable(
            @PathVariable(value = "idHotel") Long idHotel,
            Model model
    ){
        // Menghapus Hotel sesuai dengan idHotel
        HotelModel hotel = hotelService.deleteHotel(idHotel);

        model.addAttribute("id", idHotel);
        model.addAttribute("hotel", hotel);
        return "delete-hotel";
    }

    @RequestMapping("/hotel/viewall")
    public String listHotel(Model model){

        // Mendapatkan semua HotelModel
        List<HotelModel> listHotel = hotelService.getHotelList();

        // Add variabel semua HotelModel ke 'listHotel' untuk dirender pada thymeleaf
        model.addAttribute("listHotel", listHotel);

        model.addAttribute("page", "View All Hotel");

        // Return view template yang diinginkan
        return "viewall-hotel";
    }
}