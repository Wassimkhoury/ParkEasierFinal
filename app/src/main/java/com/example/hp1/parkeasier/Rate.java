package com.example.hp1.parkeasier;

/**
 * Created by Hp1 on 25/01/2018.
 */

public class Rate {
    private  long id;
    private String carnum;
    private String date;
    private double rate;
    private int parkingnum;
    private int floornum;

    public Rate(long id, String carnum, String date, double rate, int parkingnum, int floornum) {
        this.id = id;
        this.carnum = carnum;
        this.date = date;
        this.rate = rate;
        this.parkingnum = parkingnum;
        this.floornum = floornum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getParkingnum() {
        return parkingnum;
    }

    public void setParkingnum(int parkingnum) {
        this.parkingnum = parkingnum;
    }

    public int getFloornum() {
        return floornum;
    }

    public void setFloornum(int floornum) {
        this.floornum = floornum;
    }
}
