package com.siglo.example.dao.jpa;

import com.siglo.example.domain.Profesor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ProfesorRepository  extends PagingAndSortingRepository<Profesor, Long> {
    Profesor findProfesorById(Long id);
    Page findAll(Pageable pageable);
}
