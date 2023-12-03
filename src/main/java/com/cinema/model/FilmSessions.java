package com.cinema.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class FilmSessions {

    private int id;
    private int filmId;
    private int hallsId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int price;

    public FilmSessions() {
    }

    public FilmSessions(int id, int filmId, int hallsId, LocalDateTime startTime, LocalDateTime endTime, int price) {
        this.id = id;
        this.filmId = filmId;
        this.hallsId = hallsId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getHallsId() {
        return hallsId;
    }

    public void setHallsId(int hallsId) {
        this.hallsId = hallsId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FilmSessions that = (FilmSessions) o;
        return id == that.id && filmId == that.filmId && hallsId == that.hallsId && price == that.price && startTime.equals(that.startTime) && endTime.equals(that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filmId, hallsId, startTime, endTime, price);
    }

    @Override
    public String toString() {
        return "FilmSessions{"
                + "id=" + id
                + ", filmId=" + filmId
                + ", hallsId=" + hallsId
                + ", startTime=" + startTime
                + ", endTime=" + endTime
                + ", price=" + price
                + '}';
    }
}
