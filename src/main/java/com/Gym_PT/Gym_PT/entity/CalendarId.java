package com.Gym_PT.Gym_PT.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class CalendarId implements Serializable {

    private Long userId;
    private LocalDate date;

    public CalendarId() {}

    public CalendarId(Long userId, LocalDate date) {
        this.userId = userId;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalendarId that = (CalendarId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, date);
    }
}