package com.cinema.controller;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class IndexControllerTest {

    @Test
    public void whenRequestIndexPageThenGetPageWithHome() {
        IndexController indexController = new IndexController();
        var view = indexController.getIndex();
        assertThat(view).isEqualTo("index");
    }
}
