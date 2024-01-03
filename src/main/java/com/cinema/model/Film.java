package com.cinema.model;

import com.cinema.dto.FilmDto;

import java.util.Map;
import java.util.Objects;

public class Film {

    public static final Map<String, String> COLUMN_MAPPING = Map.of(
            "id", "id",
            "name", "name",
            "description", "description",
            "film_year", "year",
            "genre_id", "genreId",
            "minimal_age", "minimalAge",
            "duration_in_minutes", "durationInMinutes",
            "file_id", "fileId"
    );

    private int id;
    private String name;
    private String description;
    private int year;
    private int genreId;
    private int minimalAge;
    private int durationInMinutes;
    private int fileId;

    public Film() {
    }

    public Film(FilmBuilder filmBuilder) {
        if (filmBuilder == null) {
            throw new IllegalArgumentException("FilmBuilder has not found!");
        }
        if (filmBuilder.id == 0) {
            throw new IllegalArgumentException("Provide film id");
        }
        this.id = filmBuilder.id;
        this.name = filmBuilder.name;
        this.description = filmBuilder.description;
        this.year = filmBuilder.year;
        this.minimalAge = filmBuilder.minimalAge;
        this.durationInMinutes = filmBuilder.durationInMinutes;
        this.genreId = filmBuilder.genreId;
        this.fileId = filmBuilder.fileId;
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
        Film film = (Film) o;
        return id == film.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public static class FilmBuilder {
        private int id;
        private String name;
        private String description;
        private int year;
        private int minimalAge;
        private int durationInMinutes;
        private int genreId;
        private int fileId;

        public FilmBuilder() {
            super();
        }

        public FilmBuilder filmId(int id) {
            this.id = id;
            return this;
        }

        public FilmBuilder filmTitle(String name) {
            this.name = name;
            return this;
        }

        public FilmBuilder filmDescription(String description) {
            this.description = description;
            return this;
        }

        public FilmBuilder filmYear(int year) {
            this.year = year;
            return this;
        }

        public FilmBuilder filmMinimalAge(int minimalAge) {
            this.minimalAge = minimalAge;
            return this;
        }

        public FilmBuilder filmDurationInMinutes(int durationInMinutes) {
            this.durationInMinutes = durationInMinutes;
            return this;
        }

        public FilmBuilder filmGenre(int genreId) {
            this.genreId = genreId;
            return this;
        }

        public FilmBuilder filmFileId(int fileId) {
            this.fileId = fileId;
            return this;
        }

        public Film build() {
            Film film;
            if (validateFile()) {
                film = new Film(this);
            } else {
                throw new IllegalArgumentException("Film objects can't be build without required details");
            }
            return film;
        }

        private boolean validateFile() {
            return (id != 0);
        }
    }
}
