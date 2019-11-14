package step;

public class Menu {

  public String show() {
    StringBuilder sb = new StringBuilder();
    sb.append("========================");
    sb.append("|    Booking App       |");
    sb.append("========================");
    sb.append("| 1. Show timetable    |");
    sb.append("| 2. Make a booking    |");
    sb.append("| 3. Show my bookings  |");
    sb.append("| 4. Cancel my booking |");
    sb.append("| 5. Exit              |");
    sb.append("========================");
    return sb.toString();
  }
}
