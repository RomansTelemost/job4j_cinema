package com.cinema.repository.genre;

import com.cinema.model.Genre;

public interface GenreRepository {

    Genre findById(int id);
}
