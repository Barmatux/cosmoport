package com.space.service;

import com.space.model.Ship;
import com.space.repository.ShipManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShipService implements ShipServiceInterface {

    @Autowired
    private ShipManagerInterface shipManager;


    @Override
    @Transactional
    public void createShip(Ship ship) {
        shipManager.createShip(ship);
    }

    @Override
    @Transactional
    public int getShipCount() {
        return shipManager.getShipCount();

    }

    @Override
    @Transactional
    public Ship getShipById(Long id) {
        return shipManager.getShipById(id);
    }

    @Override
    @Transactional
    public void updateShip(Ship ship) {
        shipManager.updateShip(ship);
    }

    @Override
    @Transactional
    public void delete(Ship ship) {
        shipManager.delete(ship);
    }

    @Transactional
    @Override
    public List<Ship> getListShips(Integer pageNumber, Integer pageSize, String order) {
        return shipManager.getListShips(pageNumber, pageSize, order);
    }

    @Transactional
    @Override
    public List<Ship> getListShips(Integer pageNumber, Integer pageSize, String name, String planet) {
        return shipManager.getListShips(pageNumber, pageSize, name, planet);
    }
}
