package com.cinema.model;

import java.util.Objects;

public class Halls {

    private int id;
    private String name;
    private int rowCount;
    private int placeCount;
    private String description;

    public Halls() {
    }

    public Halls(int id, String name, int rowCount, int placeCount, String description) {
        this.id = id;
        this.name = name;
        this.rowCount = rowCount;
        this.placeCount = placeCount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        rowCount = rowCount;
    }

    public int getPlaceCount() {
        return placeCount;
    }

    public void setPlaceCount(int placeCount) {
        this.placeCount = placeCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Halls halls = (Halls) o;
        return id == halls.id && rowCount == halls.rowCount && placeCount == halls.placeCount && Objects.equals(name, halls.name) && Objects.equals(description, halls.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, rowCount, placeCount, description);
    }

    @Override
    public String toString() {
        return "Halls{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", RowCount=" + rowCount
                + ", placeCount=" + placeCount
                + ", description='" + description + '\''
                + '}';
    }
}
