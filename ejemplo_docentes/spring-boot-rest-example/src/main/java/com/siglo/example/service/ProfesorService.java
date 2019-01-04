package com.siglo.example.service;

import com.siglo.example.dao.jpa.ProfesorRepository;
import com.siglo.example.domain.Profesor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {
    private static final Logger log = LoggerFactory.getLogger(ProfesorService.class);

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public ProfesorService() {
    }

    public Profesor createProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public Profesor getProfesor(long id) {
        return profesorRepository.findOne(id);
    }

    public void updateProfesor(Profesor profesor) {
        profesorRepository.save(profesor);
    }

    public void deleteProfesor(Long id) {
        profesorRepository.delete(id);
    }

    public Page<Profesor> getAllProfesores(Integer page, Integer size) {
        Page pageOfProfesores = profesorRepository.findAll(new PageRequest(page, size));
        if (size > 50) {
            counterService.increment("siglo.ProfesorService.getAll.largePayload");
        }
        return pageOfProfesores;
    }
}
