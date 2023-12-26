package com.cinema.repository.file;

import com.cinema.model.File;

import java.util.Optional;

public interface FileRepository {

    Optional<File> findById(int id);
}
