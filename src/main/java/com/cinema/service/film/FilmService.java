package com.cinema.service.film;

import com.cinema.dto.FilmDto;
import com.cinema.model.Film;

import java.util.Collection;
import java.util.Optional;

public interface FilmService {

    Optional<Film> findById(int id);

    Collection<FilmDto> findAll();
}
