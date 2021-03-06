package com.space.service;

import com.space.exceptions.NoSuchId;
import com.space.model.Ship;
import com.space.model.ShipType;

import java.util.List;

public interface ShipServiceInterface {
    void createShip(Ship ship);

    int getShipCount();

    Ship getShipById(Long id) throws NoSuchId;

    void updateShip(Ship ship);

    void delete(Ship ship);


    List<Ship> getListShips(Integer pageNumber, Integer pageSize, String order, String name, String planet,
                            Long after, Long before, Integer minCrewSize, Integer maxCrewSize, Double minSpeed, Double maxSpeed, Double minRating,
                            Double maxRating, ShipType shipType, Boolean isUsed);


    public Long getCountByFilter(String name, String planet, Long after, Long before, Integer minCrewSize,
                                 Integer maxCrewSize, Double minSpeed, Double maxSpeed, Double minRating,
                                 Double maxRating, ShipType shipType, Boolean isUsed);
}
