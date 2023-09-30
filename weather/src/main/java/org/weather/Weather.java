package org.weather;

import java.time.LocalDateTime;


public class Weather {
    private int id;
    private String region;
    private int temperature;
    private LocalDateTime date;

    public Weather(int id, String region, int temperature, LocalDateTime date) {
        this.id = id;
        this.region = region;
        this.temperature = temperature;
        this.date = date;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return getRegion() + " " + getTemperature() + "°C " + getDate();
    }

}
