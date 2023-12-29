package com.cinema.controller;

import com.cinema.dto.FilmDto;
import com.cinema.service.film.FilmService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FilmControllerTest {

    private FilmService filmService;
    private FilmController filmController;

    @BeforeEach
    public void initServices() {
        filmService = mock(FilmService.class);
        filmController = new FilmController(filmService);
    }

    @Test
    public void whenRequestFilmListPageThenGetPageWithFilmsPreview() {
        var film1 = new FilmDto.FilmDtoBuilder()
                .filmDtoId(1)
                .filmDtoTitle("test1")
                .filmDtoYear(2023)
                .filmDtoMinimalAge(20)
                .filmDtoDuration(100)
                .filmDtoFileId(1)
                .build();
        var film2 = new FilmDto.FilmDtoBuilder()
                .filmDtoId(2)
                .filmDtoTitle("test2")
                .filmDtoYear(2023)
                .filmDtoMinimalAge(18)
                .filmDtoDuration(150)
                .filmDtoFileId(2)
                .build();

        var expectedFilms = List.of(film1, film2);
        when(filmService.findAll()).thenReturn(expectedFilms);

        var model = new ConcurrentModel();
        var view = filmController.getAll(model);
        var actualFilms = model.getAttribute("films");

        assertThat(view).isEqualTo("films/list");
        assertThat(actualFilms).isEqualTo(expectedFilms);
    }
}
