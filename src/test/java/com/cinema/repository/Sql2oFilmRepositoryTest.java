package com.cinema.repository;

import com.cinema.configuration.DatasourceConfiguration;
import com.cinema.dto.FilmDto;
import com.cinema.model.Film;
import com.cinema.repository.file.Sql2oFileRepository;
import com.cinema.repository.film.Sql2oFilmRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class Sql2oFilmRepositoryTest {

    private static Sql2oFilmRepository sql2oFilmRepository;

    @BeforeAll
    public static void initRepositories() throws Exception {
        var properties = new Properties();
        try (var inputStream = Sql2oFileRepository.class.getClassLoader()
                .getResourceAsStream("connection.properties")) {
            properties.load(inputStream);
        }
        var url = properties.getProperty("datasource.url");
        var username = properties.getProperty("datasource.username");
        var password = properties.getProperty("datasource.password");
        var configuration = new DatasourceConfiguration();
        var datasource = configuration.connectionPool(url, username, password);
        var sql2o = configuration.databaseClient(datasource);
        sql2oFilmRepository = new Sql2oFilmRepository(sql2o);
    }

    @Test
    public void whenFindAllFilmsThenGetSame() {
        Film film = new Film.FilmBuilder()
                .filmId(1)
                .filmTitle("Hobbit")
                .filmDescription("Description Hobbit")
                .filmYear(2012)
                .filmGenre(1)
                .filmMinimalAge(16)
                .filmDurationInMinutes(200)
                .filmFileId(1)
                .build();
        assertThat(sql2oFilmRepository.findAll())
                .hasSize(3)
                .element(0)
                .usingRecursiveComparison().isEqualTo(film);
    }

    @Test
    public void whenFindByIdFilmThenGetSame() {
        Film film = new Film.FilmBuilder()
                .filmId(1)
                .filmTitle("Hobbit")
                .filmDescription("Description Hobbit")
                .filmYear(2012)
                .filmGenre(1)
                .filmMinimalAge(16)
                .filmDurationInMinutes(200)
                .filmFileId(1)
                .build();
        assertThat(sql2oFilmRepository.findById(film.getId()).get())
                .usingRecursiveComparison().isEqualTo(film);
    }
}
