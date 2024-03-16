package com.example.lab4.repositories;

import com.example.lab4.model.HitEntity;
import com.example.lab4.model.HitEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HitRepo extends CrudRepository<HitEntity, Long> {
    List<HitEntity> findAll();
}
