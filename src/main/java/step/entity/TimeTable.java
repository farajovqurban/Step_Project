package step.entity;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TimeTable {
    private final List<TimetableLine> data = new ArrayList<>();

    public TimeTable() {
        if (isExisted()) {
            load();
        } else {
            create();
        }
    }

    public boolean isExisted() {
        return false;
    }

    public void getFlight(int id) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/step/data/timetable.txt"));
            String line = null;


            while ((line = reader.readLine()) != null) {
                String[] table = line.split(".");
                if (table[0].equals(id)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("error load");
        }
    }

    public void load() {
        // load the timetable from file
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/step/data/timetable.txt"));
            String line = null;

            while ((line = reader.readLine()) != null) {
                String[] table = line.split("x");
                System.out.println(table[0]);
            }
        } catch (IOException e) {
            System.out.println("error load");
        }
    }

    public void create() {
        // read the cities from file
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

        } catch (IOException e) {
            System.out.println("error in reader");
        }


        // create the timetable
        City source = new City(1, "Kiev");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        for (int i = 0; i < cities.size(); i++) {
            LocalTime time = LocalTime.now().plusHours(i);
            LocalDate date = LocalDate.now();

            data.add(new TimetableLine(source, cities.get(i), date, time.format(dtf), 160));
        }

        // write the timetable to file
        try (
                BufferedWriter writer =
                        new BufferedWriter(new FileWriter(new File("src/main/java/step/data/timetable.txt")));
        ) {
            for (int i = 0; i < data.size(); i++) {
                String timetable = data.get(i).getDst().getId() + ". " + data.get(i).getSrc() + " -> " + data.get(i).getDst() + " x :" + data
                        .get(i).getDate() + " x " + data.get(i).getTime() + " x " + data.get(i).getSeats();
                writer.write(timetable);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("timetable error");
        }
    }
}
