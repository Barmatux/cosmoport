package com.space.repository;

import com.space.model.Ship;
import com.space.model.ShipType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShipManager implements ShipManagerInterface {


    @Autowired
    private ShipRepository repository;

    @Override
//    @Transactional
    public void createShip(Ship ship) {
        repository.save(ship);
    }

    @Override
//    @Transactional
    public int getShipCount() {

        return (int) repository.count();
    }

    @Override
    public Ship getShipById(Long id) {
        return repository.findById(id).get();

    }

    @Override
    public void updateShip(Ship ship) {
        repository.saveAndFlush(ship);
    }

    @Override

    public void delete(Ship ship) {
        repository.deleteById(ship.getId());
    }

    @Override
    @SuppressWarnings("Unchecked")

    public List<Ship> getListShips(Integer pageNumber, Integer pageSize, String order) {
        Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by(order));
        return repository.findAll(page).getContent();
    }

    @Override
    public List<Ship> getListShips(Integer pageNumber, Integer pageSize, String order, String name, String planet,
                                   Long after, Long before, Integer minCrewSize, Integer maxCrewSize, Double minSpeed, Double maxSpeed, Double minRating,
                                   Double maxRating, ShipType shipType, Boolean isUsed) {
        return repository.findByFilter(pageNumber, pageSize,order, name, planet,after,before,minCrewSize,maxCrewSize,minSpeed,maxSpeed,
                minRating,maxRating,shipType,isUsed);
    }
}
