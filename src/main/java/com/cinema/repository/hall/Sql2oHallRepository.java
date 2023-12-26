package com.cinema.repository.hall;

import com.cinema.model.Hall;
import org.sql2o.Sql2o;

public class Sql2oHallRepository implements HallRepository {
    private final Sql2o sql2o;

    public Sql2oHallRepository(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public Hall findById(int id) {
        try (var connection = sql2o.open()) {
            var query = connection.createQuery("SELECT * FROM halls WHERE id = :id");
            query.addParameter("id", id);
            return query.setColumnMappings(Hall.COLUMN_MAPPING).executeAndFetchFirst(Hall.class);
        }
    }
}
