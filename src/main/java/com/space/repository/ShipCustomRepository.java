package com.space.repository;

import com.space.model.Ship;

import java.util.List;

public interface ShipCustomRepository {
    List<Ship> findByFilter(Integer pageNumber, Integer pageSize, String name, String planet);
}
