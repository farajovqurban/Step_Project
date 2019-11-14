package step.entity;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class FlightInfo {
    private String date;
    private City destination;
    private long seats = 160;

    public void create(){

        List<City> cities = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/step/data/cities.txt"));
            String line = null;
            for (int i = 1; i < 22; i++) {
                if ((line = reader.readLine()) != null) {
                    cities.add(new City(i, line));
                    //System.out.println(cities);
                }
            }
        }
        catch (IOException e){
            System.out.println("reader error");
        }
        try {

            BufferedWriter flightWriter = new BufferedWriter(new FileWriter(new File("src/main/java/step/data/flightInfo.txt")));
            for (int i = 0; i < cities.size(); i++) {
                Random randomDate = new Random();
                int day = randomDate.nextInt(30);
                int month = randomDate.nextInt(12);
                date = day + "/" + month;

                //String flightInfo = date +
            }
        }
        catch (IOException e){
            System.out.println("flight writer error");
        }
    }


    public FlightInfo(String date, City destination, long seats) {
        this.date = date;
        this.destination = destination;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "FlightInfo{" +
                "date=" + date +
                ", destination=" + destination +
                ", seats=" + seats +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public long getSeats() {
        return seats;
    }

    public void setSeats(long seats) {
        this.seats = seats;
    }
}
