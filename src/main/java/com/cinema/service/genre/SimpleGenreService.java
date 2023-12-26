package com.cinema.service.genre;

import com.cinema.model.Genre;
import com.cinema.repository.genre.GenreRepository;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;

@ThreadSafe
@Service
public class SimpleGenreService implements GenreService {

    private final GenreRepository genreRepository;

    public SimpleGenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre findById(int id) {
        return genreRepository.findById(id);
    }
}
