package com.cinema.repository;

import com.cinema.configuration.DatasourceConfiguration;
import com.cinema.model.File;
import com.cinema.repository.file.Sql2oFileRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class Sql2oFileRepositoryTest {

    private static Sql2oFileRepository sql2oFileRepository;

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
        sql2oFileRepository = new Sql2oFileRepository(sql2o);
    }

    @Test
    public void whenFindFileByIdThenGetSame() {
        File file = new File(3, "Yes man", "files/Yes man.jpg");
        assertThat(sql2oFileRepository.findById(file.getId()).get()).usingRecursiveComparison().isEqualTo(file);
    }
}
