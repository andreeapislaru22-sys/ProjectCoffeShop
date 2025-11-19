package models;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    protected String name;
    protected String role; // ex: "barista", "manager"
    private List<Schedule> schedules;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
        this.schedules = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void displayRole() {
        System.out.println(name + " - " + role);
    }

    public boolean isManager() {
        return "manager".equalsIgnoreCase(role);
    }

    public void addSchedule(String dayOfWeek, LocalTime start, LocalTime end) {
        schedules.add(new Schedule(dayOfWeek, start, end));
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    @Override
    public String toString() {
        return name + " [" + role + "]";
    }

    /**
     * Clasă internă non-statică care reprezintă programul angajatului.
     */
    public class Schedule {
        private String dayOfWeek;
        private LocalTime start;
        private LocalTime end;

        public Schedule(String dayOfWeek, LocalTime start, LocalTime end) {
            if(start.isAfter(end)) throw new IllegalArgumentException("Start must be before end");
            this.dayOfWeek = dayOfWeek;
            this.start = start;
            this.end = end;
        }

        public String getDayOfWeek() {
            return dayOfWeek;
        }

        public LocalTime getStart() {
            return start;
        }

        public LocalTime getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return dayOfWeek + ": " + start + " - " + end;
        }
    }
}