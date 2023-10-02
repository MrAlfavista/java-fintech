package org.example;

import org.weather.Weather;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Weather> data = new ArrayList<>();
        data.add(new Weather("Moscow", 23, LocalDateTime.of(2023, 7, 11, 19, 43)));
        data.add(new Weather("Moscow", 35, LocalDateTime.of(2023, 7, 11, 21, 33)));
        data.add(new Weather("Moscow", 17, LocalDateTime.of(2022, 10, 14, 16, 23)));
        data.add(new Weather("Moscow", 23, LocalDateTime.of(2019, 5, 14, 22, 50)));
        data.add(new Weather("Moscow", 17, LocalDateTime.of(2011, 4, 7, 10, 43)));
        data.add(new Weather("Saint-Petersburg", 17, LocalDateTime.of(2001, 4, 7, 10, 11)));
        data.add(new Weather("Saint-Petersburg", 23, LocalDateTime.of(2011, 4, 7, 10, 43)));
        data.add(new Weather("Saint-Petersburg", -19, LocalDateTime.of(2010, 2, 9, 0, 47)));
        data.add(new Weather("Saint-Petersburg", 40, LocalDateTime.of(1998, 7, 19, 13, 22)));

        var m = getWeatherGroupByTemperature(data);
        for(var i: m.keySet()){
            System.out.println(i);
            System.out.println(m.get(i));
        }
        var k = getMediumTemperature(data);
        for(var i: k.keySet()){
            System.out.println(i);
            System.out.println(k.get(i));
        }
        var v = getRegionTemperatureGroupById(data);
        for(var i: v.keySet()){
            System.out.println(i);
            System.out.println(v.get(i));
        }
        List<Weather> l = getWeathersWithTempHigherThan(data, 23);
        l.stream().forEach(System.out::println);
    }

    public static Map<String, Double> getMediumTemperature(List<Weather> data){
        return data.stream()
                    .collect(Collectors.groupingBy(Weather::getRegion,
                            Collectors.averagingDouble(Weather::getTemperature)));
    }

    public static List<Weather> getWeathersWithTempHigherThan(List<Weather> data, int t){
        return data.stream()
                .filter(d -> d.getTemperature() > t)
                .distinct()
                .collect(Collectors.toList());
    }

    public static Map<Integer, List<Integer>> getRegionTemperatureGroupById (List<Weather> data){
        return data.stream()
                .collect(Collectors.groupingBy(Weather::getId, Collectors.mapping(Weather::getTemperature, Collectors.toList())));
    }

    public static Map<Integer, List<Weather>> getWeatherGroupByTemperature(List<Weather> data){
        return data.stream()
                .collect(Collectors.groupingBy(Weather::getTemperature));
    }
}