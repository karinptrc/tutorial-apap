package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    // Check error for empty id
    private String checkError(HotelModel hotel, String request, Model model){
        if (request.equals("view") && hotel != null){
            model.addAttribute("hotel", hotel);
            return "view-hotel";
        }
        if (request.equals("update") && hotel != null){
            model.addAttribute("hotel", hotel);
            return "update-telepon";
        }
        if (request.equals("delete") && hotel != null){
            model.addAttribute("hotel", hotel);
            return "delete-hotel";
        }
        return "error";
    }

    // Routing URL yang diinginkan
    @RequestMapping("/hotel/add")
    public String addHotel(
            // Request parameter yang dibawa
            @RequestParam(value = "idHotel", required = true) String idHotel,
            @RequestParam(value = "namaHotel", required = true) String namaHotel,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            Model model
    ){
        // Membuat objek HotelModel
        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);

        // Memanggil service addHotel
        hotelService.addHotel(hotel);

        // Add variabel id hotel ke 'idHotel' untuk di render pada thymeleaf
        model.addAttribute("idHotel", idHotel);

        // Return view template yang digunakan
        return "add-hotel";
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

    @RequestMapping("/hotel/view")
    public String detailHotel(
            @RequestParam(value = "idHotel") String idHotel,
            Model model
    ){
        // Mendapatkan HotelModel sesuai dengan idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        return checkError(hotel, "view", model);
    }

    @GetMapping(value = "hotel/view/id-hotel/{idHotel}")
    public String detailHotelWithPathVariable(
            @PathVariable(value = "idHotel") String idHotel,
            Model model
    ){
        // Mendapatkan HotelModel sesuai dengan idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

        return checkError(hotel, "view", model);
    }

    @GetMapping(value = "hotel/update/id-hotel/{idHotel}/no-telepon/{newNoTelepon}")
    public String updateNoTeleponWithPathVariable(
            @PathVariable(value = "idHotel") String idHotel,
            @PathVariable(value = "newNoTelepon") String newNoTelepon,
            Model model
    ){
        // Mendapatkan HotelModel sesuai dengan idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        hotel.setNoTelepon(newNoTelepon);

        return checkError(hotel, "update", model);
    }

    @GetMapping(value = "hotel/delete/id-hotel/{idHotel}")
    public String deleteHotelWithPathVariable(
            @PathVariable(value = "idHotel") String idHotel,
            Model model
    ){
        // Menghapus Hotel sesuai dengan idHotel
        HotelModel hotel = hotelService.deleteHotelByIdHotel(idHotel);

        return checkError(hotel, "delete", model);
    }
}
