package com.divine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings", method = RequestMethod.GET)
public class BookingController {
    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> all(){
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}")
    public List<HotelBooking> getAffordable(@PathVariable double price){
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public List<HotelBooking> delete(@PathVariable Long id){
        bookingRepository.delete(id);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public HotelBooking getHotel(@PathVariable Long id){
        return bookingRepository.findOne(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public List<HotelBooking> update(@RequestBody HotelBooking hotelBooking){
        HotelBooking resultHotelBooking = new HotelBooking();//bookingRepository.findOne(hotelBooking.getId());
        resultHotelBooking.setHotelName(hotelBooking.getHotelName());
        resultHotelBooking.setNumberOfNight(hotelBooking.getNumberOfNight());
        resultHotelBooking.setPricePerNight(hotelBooking.getPricePerNight());
        bookingRepository.save(resultHotelBooking);
        return bookingRepository.findAll();
    }
}
