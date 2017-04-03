package com.divine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository <HotelBooking, Long> {
    public List<HotelBooking> findByPricePerNightLessThan(Double price);
}
