package com.cinema.repository.film;

import com.cinema.model.Film;

import java.util.Collection;
import java.util.Optional;

public interface FilmRepository {

    Optional<Film> findById(int id);

    Collection<Film> findAll();
}
