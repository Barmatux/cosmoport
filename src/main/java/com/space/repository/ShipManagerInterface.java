package com.space.repository;

import com.space.model.Ship;

import java.util.List;

public interface ShipManagerInterface {
    void createShip(Ship ship);

    int getShipCount();

    Ship getShipById(Long id);

    void updateShip(Ship ship);

    void delete(Ship ship);

    List<Ship> getListShips(Integer pageNumber, Integer pageSize, String order);

    List<Ship> getListShips(Integer pageNumber, Integer pageSize, String name, String planet);
}
