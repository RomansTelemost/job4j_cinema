package com.cinema.service.hall;

import com.cinema.model.Hall;
import com.cinema.repository.hall.HallRepository;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;

@ThreadSafe
@Service
public class SimpleHallService implements HallService {

    private final HallRepository hallRepository;

    public SimpleHallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @Override
    public Hall findById(int id) {
        return hallRepository.findById(id);
    }
}
