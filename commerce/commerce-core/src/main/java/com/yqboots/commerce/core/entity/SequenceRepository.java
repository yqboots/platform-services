package com.yqboots.commerce.core.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceRepository extends CrudRepository<Sequence, Long> {
    Sequence findByType(String type);
}
