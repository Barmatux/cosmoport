package com.space.service;

import com.space.model.Ship;
import com.space.model.ShipType;
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

    public Ship getShipById(Long id) {
        return shipManager.getShipById(id);
    }


    public void updateShip(Ship ship) {
        shipManager.updateShip(ship);
    }

    @Override

    public void delete(Ship ship) {
        shipManager.delete(ship);
    }


    @Override
    public List<Ship> getListShips(Integer pageNumber, Integer pageSize, String order) {
        return shipManager.getListShips(pageNumber, pageSize, order);
    }


    @Override
    public List<Ship> getListShips(Integer pageNumber, Integer pageSize, String order, String name, String planet,
                                   Long after, Long before, Integer minCrewSize, Integer maxCrewSize, Double minSpeed, Double maxSpeed, Double minRating,
                                   Double maxRating, ShipType shipType, Boolean isUsed) {
        return shipManager.getListShips(pageNumber, pageSize,order, name, planet,after,before,minCrewSize,maxCrewSize,minSpeed,maxSpeed,
                minRating,maxRating,shipType,isUsed);
    }
}
