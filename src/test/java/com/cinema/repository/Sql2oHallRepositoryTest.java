package com.cinema.repository;

import com.cinema.configuration.DatasourceConfiguration;
import com.cinema.model.Hall;
import com.cinema.repository.file.Sql2oFileRepository;
import com.cinema.repository.hall.Sql2oHallRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class Sql2oHallRepositoryTest {

    private static Sql2oHallRepository sql2oHallRepository;

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
        sql2oHallRepository = new Sql2oHallRepository(sql2o);
    }

    @Test
    public void whenFindByIdHallThenGetSame() {
        Hall hall = new Hall(1, "First hall", 5,
                10, "F");
        assertThat(sql2oHallRepository.findById(hall.getId()))
                .usingRecursiveComparison().isEqualTo(hall);
    }
}
