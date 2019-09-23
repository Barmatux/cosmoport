package com.space.repository;

import com.space.model.Ship;
import com.space.model.ShipType;

import java.util.List;

public interface ShipManagerInterface {
    void createShip(Ship ship);

    int getShipCount();

    Ship getShipById(Long id) throws NoSuchFieldException;

    void updateShip(Ship ship);

    void delete(Ship ship);



    List<Ship> getListShips(Integer pageNumber, Integer pageSize, String order, String name, String planet,
                            Long after, Long before, Integer minCrewSize, Integer maxCrewSize, Double minSpeed, Double maxSpeed, Double minRating,
                            Double maxRating, ShipType shipType,Boolean isUsed);

    public Long getCountByFilter(Integer pageNumber, Integer pageSize, String order, String name, String planet,
                                 Long after, Long before, Integer minCrewSize, Integer maxCrewSize, Double minSpeed, Double maxSpeed, Double minRating,
                                 Double maxRating, ShipType shipType, Boolean isUsed) ;
}
