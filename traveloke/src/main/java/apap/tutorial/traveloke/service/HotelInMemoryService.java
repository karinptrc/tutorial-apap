package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelInMemoryService implements HotelService{

    private List<HotelModel> listHotel;

    //Constructor

    public HotelInMemoryService() {
        listHotel = new ArrayList<>();
    }

    @Override
    public void addHotel(HotelModel hotel) {
        listHotel.add(hotel);
    }

    @Override
    public List<HotelModel> getHotelList() {
        return listHotel;
    }

    @Override
    public HotelModel getHotelByIdHotel(String idHotel) {
        for (HotelModel hotelModel : listHotel) {
            if (hotelModel.getIdHotel().equals(idHotel)) {
                return hotelModel;
            }
        }
        return null;
    }

    @Override
    public HotelModel deleteHotelByIdHotel(String idHotel) {
        HotelModel hotel;
        for (HotelModel hotelModel : listHotel) {
            if (hotelModel.getIdHotel().equals(idHotel)) {
                hotel = hotelModel;
                listHotel.remove(hotelModel);
                return hotel;
            }
        }
        return null;
    }

    @Override
    public HotelModel updateTeleponHotel(String idHotel, String newTelepon) {
        for (HotelModel hotelModel : listHotel) {
            if (hotelModel.getIdHotel().equals(idHotel)) {
                hotelModel.setNoTelepon(newTelepon);
                return hotelModel;
            }
        }
        return null;
    }
}
