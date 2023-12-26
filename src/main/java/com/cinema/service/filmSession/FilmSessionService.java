package com.cinema.service.filmSession;

import com.cinema.dto.FilmSessionDto;
import com.cinema.dto.SessionPlaceDto;

import java.util.Collection;

public interface FilmSessionService {

    SessionPlaceDto findById(int id);

    Collection<FilmSessionDto> findAll();
}
