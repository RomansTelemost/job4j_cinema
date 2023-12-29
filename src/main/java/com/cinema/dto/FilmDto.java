package com.cinema.dto;

public class FilmDto {

    private int id;
    private String title;
    private String description;
    private int year;
    private int minimalAge;
    private int duration;
    private String genre;
    private int fileId;

    public FilmDto(FilmDtoBuilder filmDtoBuilder) {
        if (filmDtoBuilder == null) {
            throw new IllegalArgumentException("FilmDtoBuilder has not found!");
        }
        if (filmDtoBuilder.id == 0) {
            throw new IllegalArgumentException("Provide filmDto id");
        }
        this.id = filmDtoBuilder.id;
        this.title = filmDtoBuilder.title;
        this.description = filmDtoBuilder.description;
        this.year = filmDtoBuilder.year;
        this.minimalAge = filmDtoBuilder.minimalAge;
        this.duration = filmDtoBuilder.duration;
        this.genre = filmDtoBuilder.genre;
        this.fileId = filmDtoBuilder.fileId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {
        return year;
    }

    public int getMinimalAge() {
        return minimalAge;
    }

    public int getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public int getFileId() {
        return fileId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FilmDto [id=").append(id).append(", title=").append(title).append(", description=")
                .append(description).append(", year=").append(year).append(", minimalAge=").append(minimalAge)
                .append(", duration=").append(duration).append(", genre=").append(genre)
                .append(", fileId=").append(fileId).append("]");
        return builder.toString();

    }

    public static class FilmDtoBuilder {
        private int id;
        private String title;
        private String description;
        private int year;
        private int minimalAge;
        private int duration;
        private String genre;
        private int fileId;

        public FilmDtoBuilder() {
            super();
        }

        public FilmDtoBuilder filmDtoId(int id) {
            this.id = id;
            return this;
        }

        public FilmDtoBuilder filmDtoTitle(String title) {
            this.title = title;
            return this;
        }

        public FilmDtoBuilder filmDtoDescription(String description) {
            this.description = description;
            return this;
        }

        public FilmDtoBuilder filmDtoYear(int year) {
            this.year = year;
            return this;
        }

        public FilmDtoBuilder filmDtoMinimalAge(int minimalAge) {
            this.minimalAge = minimalAge;
            return this;
        }

        public FilmDtoBuilder filmDtoDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public FilmDtoBuilder filmDtoGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public FilmDtoBuilder filmDtoFileId(int fileId) {
            this.fileId = fileId;
            return this;
        }

        public FilmDto build() {
            FilmDto filmDto;
            if (validateFileDto()) {
                filmDto = new FilmDto(this);
            } else {
                throw new IllegalArgumentException("FilmDto objects can't be build without required details");
            }
            return filmDto;
        }

        private boolean validateFileDto() {
            return (id != 0);
        }
    }
}
