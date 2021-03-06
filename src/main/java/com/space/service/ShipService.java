package com.space.service;

import com.space.exceptions.NoSuchId;
import com.space.model.Ship;
import com.space.model.ShipType;
import com.space.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShipService implements ShipServiceInterface {

    @Autowired
    private ShipRepository shipRepository;


    @Override
    @Transactional
    public void createShip(Ship ship) {
        shipRepository.save(ship);
    }

    @Override
    @Transactional
    public int getShipCount() {
        return (int) shipRepository.count();
    }

    @Override

    public Ship getShipById(Long id) {
        return shipRepository.findById(id).orElseThrow(NoSuchId::new);
    }


    public void updateShip(Ship ship) {
        shipRepository.saveAndFlush(ship);
    }

    @Override

    public void delete(Ship ship) {
        shipRepository.deleteById(ship.getId());
    }


    @Override
    public List<Ship> getListShips(Integer pageNumber, Integer pageSize, String order, String name, String planet,
                                   Long after, Long before, Integer minCrewSize, Integer maxCrewSize, Double minSpeed, Double maxSpeed, Double minRating,
                                   Double maxRating, ShipType shipType, Boolean isUsed) {
        return shipRepository.findByFilter(pageNumber, pageSize, order, name, planet, after, before, minCrewSize, maxCrewSize, minSpeed, maxSpeed,
                minRating, maxRating, shipType, isUsed);
    }

    @Override
    public Long getCountByFilter(String name, String planet, Long after, Long before, Integer minCrewSize,
                                 Integer maxCrewSize, Double minSpeed, Double maxSpeed, Double minRating,
                                 Double maxRating, ShipType shipType, Boolean isUsed) {

        return shipRepository.getCountByFilter(name, planet, after, before, minCrewSize, maxCrewSize, minSpeed, maxSpeed,
                minRating, maxRating, shipType, isUsed);
    }


}
