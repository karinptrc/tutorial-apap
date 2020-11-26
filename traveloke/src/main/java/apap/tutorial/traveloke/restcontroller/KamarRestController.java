package apap.tutorial.traveloke.restcontroller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.rest.HotelDetail;
import apap.tutorial.traveloke.service.HotelRestService;
import apap.tutorial.traveloke.service.KamarRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class KamarRestController {
    @Autowired
    private KamarRestService kamarRestService;

    @Autowired
    private HotelRestService hotelRestService;

    @PostMapping(value = "/kamar")
    private ResponseEntity<String> createKamar(
            @Valid @RequestBody KamarModel kamar,
            BindingResult bindingResult
    ){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        } else {
//            kamar.setHotel(hotelRestService.getHotelByIdHotel(kamar.getHotel().getId()));
            kamarRestService.createKamar(kamar);
            return ResponseEntity.ok("Add kamar success!");
        }
    }

    @GetMapping(value = "/kamar/{idKamar}")
    private KamarModel retrieveKamar(
            @PathVariable("idKamar") Long idKamar
    ){
        try{
            return kamarRestService.getKamarByIdKamar(idKamar);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Kamar "+String.valueOf(idKamar)+" Not Found"
            );
        }
    }

    @DeleteMapping(value = "/kamar/{idKamar}")
    private ResponseEntity<String> deleteKamar(@PathVariable("idKamar") Long idKamar){
        try{
            kamarRestService.deleteKamar(idKamar);
            return ResponseEntity.ok("Kamar has been deleted");
//            return ResponseEntity.ok("Kamar with ID " + String.valueOf(idKamar)+ " Deleted!");
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Kamar with ID " + String.valueOf(idKamar) + " Not Found!"
            );
        }
    }

    @PutMapping(value = "/kamar/{idKamar}")
    private ResponseEntity<String> updateKamar(
            @PathVariable(value = "idKamar") Long idKamar,
            @RequestBody KamarModel kamar
    ){
        try{
            kamarRestService.changeKamar(idKamar, kamar);
            return ResponseEntity.ok("Update kamar success!");
        } catch(NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Kamar with ID " + String.valueOf(idKamar)+" Not Found!"
            );
        }
    }

    @GetMapping(value = "/kamar-all")
    private List<KamarModel> retrieveListKamar(){
        return kamarRestService.retrieveListKamar();
    }
}
