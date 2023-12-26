package com.cinema.service.file;

import com.cinema.dto.FileDto;

import java.util.Optional;

public interface FileService {
    Optional<FileDto> getFileById(int id);
}
