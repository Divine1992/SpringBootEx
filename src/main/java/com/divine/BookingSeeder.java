package com.divine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingSeeder implements CommandLineRunner{
    private BookingRepository bookingRepository;

    @Autowired
    public BookingSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<HotelBooking> bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Capitol", 200.5, 5));
        bookings.add(new HotelBooking("Residental", 500.8, 2));
        bookings.add(new HotelBooking("ForFree", 50.0, 7));

        bookingRepository.save(bookings);
    }
}
