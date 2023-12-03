package com.cinema.model;

import java.util.Objects;

public class Films {

    private int id;
    private String name;
    private String description;
    private int year;
    private int genreId;
    private int minimalAge;
    private int durationInMinutes;
    private int fileId;

    public Films() {
    }

    public Films(int id, String name, int year, int genreId,
                 int minimalAge, int durationInMinutes, int fileId) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genreId = genreId;
        this.minimalAge = minimalAge;
        this.durationInMinutes = durationInMinutes;
        this.fileId = fileId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getMinimalAge() {
        return minimalAge;
    }

    public void setMinimalAge(int minimalAge) {
        this.minimalAge = minimalAge;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Films films = (Films) o;
        return id == films.id && year == films.year && genreId == films.genreId && minimalAge == films.minimalAge && durationInMinutes == films.durationInMinutes && fileId == films.fileId && name.equals(films.name) && description.equals(films.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, year, genreId, minimalAge, durationInMinutes, fileId);
    }

    @Override
    public String toString() {
        return "Film{"
                + "id="
                + id + ", name='" + name + '\''
                + ", description='" + description + '\''
                + ", year=" + year
                + ", genreId=" + genreId
                + ", minimalAge=" + minimalAge
                + ", durationInMinutes=" + durationInMinutes
                + ", fileId=" + fileId
                + '}';
    }
}
