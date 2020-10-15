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

    @GetMapping("/")
    private String home(){
        return "home";
    }

    @GetMapping("/hotel/add")
    public String addHotelFormPage(Model model){
        model.addAttribute("hotel", new HotelModel());
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
            Integer size = kamarService.getSizeListKamar(idHotel);

            model.addAttribute("hotel", hotel);
            model.addAttribute("size", size);
            model.addAttribute("listKamar", listKamar);

            return "view-hotel";
    }

    @GetMapping("/hotel/view/{idHotel}")
    public String viewDetailHotelPathVariable(
            @PathVariable(value = "idHotel") Long idHotel,
            Model model
    ){
            HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
            List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
            Integer size = kamarService.getSizeListKamar(idHotel);

            model.addAttribute("hotel", hotel);
            model.addAttribute("size", size);
            model.addAttribute("listKamar", listKamar);
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

        // Return view template yang diinginkan
        return "viewall-hotel";
    }
}
// ------------- Dari tutorial 2 -------------
//    // Check error for empty id
//    private String checkError(HotelModel hotel, String request, Model model){
//        if (request.equals("view") && hotel != null){
//            model.addAttribute("hotel", hotel);
//            return "view-hotel";
//        }
//        if (request.equals("update") && hotel != null){
//            model.addAttribute("hotel", hotel);
//            return "update-telepon";
//        }
//        if (request.equals("delete") && hotel != null){
//            model.addAttribute("hotel", hotel);
//            return "delete-hotel";
//        }
//        return "error";
//    }
//
//    // Routing URL yang diinginkan
//    @RequestMapping("/hotel/add")
//    public String addHotel(
//            // Request parameter yang dibawa
//            @RequestParam(value = "idHotel", required = true) String idHotel,
//            @RequestParam(value = "namaHotel", required = true) String namaHotel,
//            @RequestParam(value = "alamat", required = true) String alamat,
//            @RequestParam(value = "noTelepon", required = true) String noTelepon,
//            Model model
//    ){
//        // Membuat objek HotelModel
//        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);
//
//        // Memanggil service addHotel
//        hotelService.addHotel(hotel);
//
//        // Add variabel id hotel ke 'idHotel' untuk di render pada thymeleaf
//        model.addAttribute("idHotel", idHotel);
//
//        // Return view template yang digunakan
//        return "add-hotel";
//    }
//
//    @RequestMapping("/hotel/viewall")
//    public String listHotel(Model model){
//
//        // Mendapatkan semua HotelModel
//        List<HotelModel> listHotel = hotelService.getHotelList();
//
//        // Add variabel semua HotelModel ke 'listHotel' untuk dirender pada thymeleaf
//        model.addAttribute("listHotel", listHotel);
//
//        // Return view template yang diinginkan
//        return "viewall-hotel";
//    }
//
//    @RequestMapping("/hotel/view")
//    public String detailHotel(
//            @RequestParam(value = "idHotel") String idHotel,
//            Model model
//    ){
//        // Mendapatkan HotelModel sesuai dengan idHotel
//        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//
//        return checkError(hotel, "view", model);
//    }
//
//    @GetMapping(value = "hotel/view/id-hotel/{idHotel}")
//    public String detailHotelWithPathVariable(
//            @PathVariable(value = "idHotel") String idHotel,
//            Model model
//    ){
//        // Mendapatkan HotelModel sesuai dengan idHotel
//        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//
//        return checkError(hotel, "view", model);
//    }
//
//    @GetMapping(value = "hotel/update/id-hotel/{idHotel}/no-telepon/{newNoTelepon}")
//    public String updateNoTeleponWithPathVariable(
//            @PathVariable(value = "idHotel") String idHotel,
//            @PathVariable(value = "newNoTelepon") String newNoTelepon,
//            Model model
//    ){
//        // Mendapatkan HotelModel sesuai dengan idHotel
//        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
//        hotel.setNoTelepon(newNoTelepon);
//
//        return checkError(hotel, "update", model);
//    }
//
//    @GetMapping(value = "hotel/delete/id-hotel/{idHotel}")
//    public String deleteHotelWithPathVariable(
//            @PathVariable(value = "idHotel") String idHotel,
//            Model model
//    ){
//        // Menghapus Hotel sesuai dengan idHotel
//        HotelModel hotel = hotelService.deleteHotelByIdHotel(idHotel);
//
//        return checkError(hotel, "delete", model);
//    }
//}
