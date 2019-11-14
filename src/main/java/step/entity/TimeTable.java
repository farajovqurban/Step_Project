package step.entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

  public void load() {
    // load the timetable from file
    try {
      BufferedReader reader = new BufferedReader(new FileReader("src/main/java/step/data/timetable.txt"));
      String line = null;
      while ((line = reader.readLine()) != null){
        System.out.println(line);
      }
    }
    catch (IOException e){
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
    //bosso -->1. kiev - bosso - 12
    //         2. kiev - odessa - 13
     City source = new City(1, "Kiev");

    for (int i = 0; i < cities.size(); i++) {
      Random time = new Random();

      data.add(new TimetableLine(source, cities.get(i), time.nextInt(23)));


      //System.out.println(data);
    }

    // write the timetable to file

    try (
            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(new File("src/main/java/step/data/timetable.txt")));
    ){
      for (int i = 0; i < data.size(); i++) {
        String timetable = data.get(i).getDst().getId() + ". " + data.get(i).getSrc() + " -> " + data.get(i).getDst() + ": " + data.get(i).getTime();
        writer.write(timetable);
        writer.newLine();
      }
    }
      catch(IOException e){
        System.out.println("timetable errpor");
    }
  }
}
