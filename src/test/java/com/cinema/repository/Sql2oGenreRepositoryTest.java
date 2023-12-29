package com.cinema.repository;

import com.cinema.configuration.DatasourceConfiguration;
import com.cinema.model.Genre;
import com.cinema.repository.file.Sql2oFileRepository;
import com.cinema.repository.genre.Sql2oGenreRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class Sql2oGenreRepositoryTest {

    private static Sql2oGenreRepository sql2oGenreRepository;

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
        sql2oGenreRepository = new Sql2oGenreRepository(sql2o);
    }

    @Test
    public void whenFindByIdGenreThenGetSame() {
        Genre genre = new Genre(3, "Comedy");
        assertThat(sql2oGenreRepository.findById(genre.getId()))
                .usingRecursiveComparison().isEqualTo(genre);
    }
}
