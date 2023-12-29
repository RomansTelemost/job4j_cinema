package com.cinema.service.film;

import com.cinema.dto.FilmDto;
import com.cinema.model.Film;
import com.cinema.repository.film.FilmRepository;
import com.cinema.service.genre.GenreService;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
@Service
public class SimpleFilmService implements FilmService {
    private final FilmRepository filmRepository;
    private final GenreService genreService;
    private final ConcurrentHashMap<Integer, FilmDto> filmsDto = new ConcurrentHashMap<>();

    public SimpleFilmService(FilmRepository sql2oFilmRepository, GenreService genreService) {
        this.filmRepository = sql2oFilmRepository;
        this.genreService = genreService;
    }

    @Override
    public Optional<Film> findById(int id) {
        return filmRepository.findById(id);
    }

    @Override
    public Collection<FilmDto> findAll() {
        var films = filmRepository.findAll();
        for (Film film : films) {
            FilmDto filmDto = new FilmDto.FilmDtoBuilder()
                    .filmDtoId(film.getId())
                    .filmDtoTitle(film.getName())
                    .filmDtoDescription(film.getDescription())
                    .filmDtoYear(film.getYear())
                    .filmDtoMinimalAge(film.getMinimalAge())
                    .filmDtoDuration(film.getDurationInMinutes())
                    .filmDtoGenre(genreService.findById(film.getGenreId()).getName())
                    .filmDtoFileId(film.getId())
                    .build();
            filmsDto.putIfAbsent(film.getId(), filmDto);
        }
        return filmsDto.values();
    }
}
