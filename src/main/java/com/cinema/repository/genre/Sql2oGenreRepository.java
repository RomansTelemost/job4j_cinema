package com.cinema.repository.genre;

import com.cinema.model.Genre;
import org.sql2o.Sql2o;

public class Sql2oGenreRepository implements GenreRepository {

    private final Sql2o sql2o;

    public Sql2oGenreRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Genre findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM genres WHERE id = :id");
            query.addParameter("id", id);
            return query.executeAndFetchFirst(Genre.class);
        }
    }
}
