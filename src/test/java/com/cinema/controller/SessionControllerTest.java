package com.cinema.controller;

import com.cinema.dto.FilmSessionDto;
import com.cinema.dto.SessionPlaceDto;
import com.cinema.service.filmsession.FilmSessionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.*;

public class SessionControllerTest {

    private FilmSessionService filmSessionService;
    private FilmSessionController filmSessionController;

    @BeforeEach
    public void initServices() {
        filmSessionService = mock(FilmSessionService.class);
        filmSessionController = new FilmSessionController(filmSessionService);
    }

    @Test
    public void whenRequestSessionsListPageThenGetPageWithSessionsPreview() {
        var session1 = new FilmSessionDto(1, null, null, "", "", 100);
        var session2 = new FilmSessionDto(2, null, null, "", "", 200);
        var expectedSessions = List.of(session1, session2);
        when(filmSessionService.findAll()).thenReturn(expectedSessions);

        var model = new ConcurrentModel();
        var view = filmSessionController.getAll(model);
        var actualSessions = model.getAttribute("sessions");

        assertThat(view).isEqualTo("sessions/list");
        assertThat(actualSessions).isEqualTo(expectedSessions);
    }

    @Test
    public void whenRequestSessionOnePageThenGetPageWithSessionsOne() {
        var session = new SessionPlaceDto(
                1, null, "", "", 100, null, null);
        var model = new ConcurrentModel();
        var idArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
        when(filmSessionService.findById(idArgumentCaptor.capture())).thenReturn(session);

        var view = filmSessionController.getById(model, session.getId(), new MockHttpServletRequest());
        var actualId = idArgumentCaptor.getValue();

        assertThat(view).isEqualTo("sessions/one");
        assertThat(actualId).isEqualTo(session.getId());
    }
}
