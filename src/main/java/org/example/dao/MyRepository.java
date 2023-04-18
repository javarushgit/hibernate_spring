package org.example.dao;

import org.example.entity.PlayerEntity;
import org.springframework.data.repository.Repository;

public interface MyRepository extends Repository<Long, PlayerEntity> {
}
