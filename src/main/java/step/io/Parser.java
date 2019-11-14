package step.io;

public class Parser {
  public Command parse(String origin) {
    if ("1".equals(origin)) return Command.TIMETABLE_SHOW;
    else if ("2".equals(origin)) return Command.BOOKING_ADD;
    //...
    else if ("EXIT".equalsIgnoreCase(origin)) return Command.EXIT;
    else return Command.HELP;
  }
}
