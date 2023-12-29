package com.cinema.repository;

import com.cinema.configuration.DatasourceConfiguration;
import com.cinema.model.FilmSession;
import com.cinema.repository.file.Sql2oFileRepository;
import com.cinema.repository.filmsession.Sql2oFilmSessionRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class Sql2oSessionRepositoryTest {

    private static Sql2oFilmSessionRepository sql2oFilmSessionRepository;

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
        sql2oFilmSessionRepository = new Sql2oFilmSessionRepository(sql2o);
    }

    @Test
    public void whenFindAllSessionsThenGetSame() {
        var startTime = LocalDateTime.of(2017, 10, 12, 20, 22, 23);
        var endTime = LocalDateTime.of(2017, 10, 12, 21, 22, 24);
        FilmSession filmSession = new FilmSession(1, 1, 1, startTime, endTime, 210);
        assertThat(sql2oFilmSessionRepository.findAll())
                .hasSize(3)
                .element(0)
                .usingRecursiveComparison().isEqualTo(filmSession);
    }

    @Test
    public void whenFindByIdSessionThenGetSame() {
        var startTime = LocalDateTime.of(2017, 10, 12, 20, 22, 23);
        var endTime = LocalDateTime.of(2017, 10, 12, 21, 22, 24);
        FilmSession session = new FilmSession(1, 1, 1, startTime, endTime, 210);
        assertThat(sql2oFilmSessionRepository.findById(1).get())
                .usingRecursiveComparison().isEqualTo(session);
    }
}
