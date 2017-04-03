package com.divine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hotelName;
    private Double pricePerNight;
    private int numberOfNight;

    public HotelBooking(String hotelName, Double pricePerNight, int numberOfNight) {
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.numberOfNight = numberOfNight;
    }

    public HotelBooking() {
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getNumberOfNight() {
        return numberOfNight;
    }

    public void setNumberOfNight(int numberOfNight) {
        this.numberOfNight = numberOfNight;
    }

    public Long getId() {
        return id;
    }
}
