package org.weather;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;

@Getter
@Setter
@EqualsAndHashCode
public class Weather {
    private static HashMap<String, Integer> regionsToId = new HashMap<>();
    private int id;
    private String region;
    private int temperature;
    private LocalDateTime date;

    public Weather(String region, int temperature, LocalDateTime date) {
        if(regionsToId.containsKey(region)){
            this.id = regionsToId.get(region);
        } else {
            this.id = regionsToId.size();
            regionsToId.put(region, this.id);
        }
        this.region = region;
        this.temperature = temperature;
        this.date = date;
    }

    @Override
    public String toString(){
        return getRegion() + " " + getTemperature() + "°C " + getDate();
    }

}
