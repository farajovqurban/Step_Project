package step.controller;

import step.entity.TimeTable;

public class TimetableController {
  public void show() {

    TimeTable timeTable = new TimeTable();
    timeTable.load();

  }
}
