package step.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class TimetableLine {
  private final City src;
  private final City dst;
  private final LocalDate date;
  private final String time;
  private int seats;

  public TimetableLine(City src, City dst, LocalDate date, String time, int seats) {
    this.src = src;
    this.dst = dst;
    this.date = date;
    this.time = time;
    this.seats = seats;
  }

  public City getSrc() {
    return src;
  }

  public City getDst() {
    return dst;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getTime() {
    return time;
  }

  public int getSeats() {
    return seats;
  }

  public void setSeats(int seats) {
    this.seats = seats;
  }

  @Override
  public String toString() {
    return "TimetableLine{" +
            "src=" + src +
            ", dst=" + dst +
            ", date=" + date +
            ", time=" + time +
            ", seats=" + seats +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TimetableLine that = (TimetableLine) o;
    return seats == that.seats &&
            Objects.equals(src, that.src) &&
            Objects.equals(dst, that.dst) &&
            Objects.equals(date, that.date) &&
            Objects.equals(time, that.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(src, dst, date, time, seats);
  }
}