package com.cinema.repository.filmSession;

import com.cinema.model.FilmSession;

import java.util.Collection;
import java.util.Optional;

public interface FilmSessionRepository {

    Optional<FilmSession> findById(int id);

    Collection<FilmSession> findAll();
}
