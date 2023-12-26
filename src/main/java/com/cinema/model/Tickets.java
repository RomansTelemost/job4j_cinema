package com.cinema.model;

import java.util.Objects;

public class Tickets {

    private int id;
    private int sessionId;
    private int rowNumber;
    private int placeNumber;
    private int userId;

    public Tickets() {
    }

    public Tickets(int id, int sessionId, int rowNumber, int placeNumber, int userId) {
        this.id = id;
        this.sessionId = sessionId;
        this.rowNumber = rowNumber;
        this.placeNumber = placeNumber;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tickets tickets = (Tickets) o;
        return id == tickets.id && sessionId == tickets.sessionId && rowNumber == tickets.rowNumber && placeNumber == tickets.placeNumber && userId == tickets.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sessionId, rowNumber, placeNumber, userId);
    }

    @Override
    public String toString() {
        return "Tickets{"
                + "id=" + id
                + ", sessionId=" + sessionId
                + ", rowNumber=" + rowNumber
                + ", placeNumber=" + placeNumber
                + ", userId=" + userId
                + '}';
    }
}