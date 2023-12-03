package com.cinema.model;

import java.util.Objects;

public class Files {

    private int id;
    private String name;
    private String path;

    public Files() {
    }

    public Files(int id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Files files = (Files) o;
        return id == files.id && Objects.equals(name, files.name) && Objects.equals(path, files.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, path);
    }

    @Override
    public String toString() {
        return "File{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", path='" + path + '\''
                + '}';
    }
}
