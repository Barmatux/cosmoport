package com.space.repository;

import com.space.model.Ship;
import com.space.model.ShipType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.util.Objects.nonNull;

public class ShipCustomRepositoryImpl implements ShipCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Ship> findByFilter(Integer pageNumber, Integer pageSize, String order, String name, String planet,
                                   Long after, Long before, Integer minCrewSize, Integer maxCrewSize, Double minSpeed, Double maxSpeed, Double minRating,
                                   Double maxRating, ShipType shipType, Boolean isUsed) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ship> query = cb.createQuery(Ship.class);
        Root<Ship> ship = query.from(Ship.class);
        Path<String> namePath = ship.get("name");
        Path<String> planetPath = ship.get("planet");
        Path<Long> yearPath = ship.get("prodDate");
        Path<Integer> crewSizePath = ship.get("crewSize");
        Path<Double> speedPath = ship.get("speed");
        Path<Double> ratingPath = ship.get("rating");
        Path<ShipType> shipTypePath = ship.get("shipType");
        Path<Boolean> isUsedPath = ship.get("isUsed");

        List<Predicate> predicates = new ArrayList<>();
        if (nonNull(name)) {
            predicates.add(cb.like(namePath, "%" + name + "%"));
        }
        if (nonNull(planet)) {
            predicates.add(cb.like(planetPath, "%"+planet+"%"));
        }
        if (nonNull(after) ) {
            predicates.add(cb.greaterThanOrEqualTo(yearPath, after));
        }

        if (nonNull(before) ) {
            predicates.add(cb.lessThanOrEqualTo(yearPath, before));
        }

        if (nonNull(minCrewSize) && nonNull(maxCrewSize)) {
            predicates.add(cb.between(crewSizePath, minCrewSize, maxCrewSize));
        }

        if (nonNull(minSpeed) && nonNull(maxSpeed)) {
            predicates.add(cb.between(speedPath, minSpeed, maxSpeed));
        }

        if (nonNull(minRating) && nonNull(maxRating)) {
            predicates.add(cb.between(ratingPath, minRating, maxRating));
        }

        if (nonNull(shipType)) {
            predicates.add((cb.equal(shipTypePath, shipType)));
        }

        if (nonNull(isUsed)) {
            predicates.add((cb.equal(isUsedPath, isUsed)));
        }


        query.select(ship).where(cb.and(predicates.
                toArray(new Predicate[predicates.size()]))).orderBy(cb.asc(ship.get(order)));

        return entityManager.createQuery(query).setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }


    @Override
    public Long getCountByFilter(Integer pageNumber, Integer pageSize, String order, String name, String planet,
                                 Long after, Long before, Integer minCrewSize, Integer maxCrewSize, Double minSpeed, Double maxSpeed, Double minRating,
                                 Double maxRating, ShipType shipType, Boolean isUsed) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();


        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<Ship> ship = query.from(Ship.class);
        Path<String> namePath = ship.get("name");
        Path<String> planetPath = ship.get("planet");
        Path<Long> yearPath = ship.get("prodDate");
        Path<Integer> crewSizePath = ship.get("crewSize");
        Path<Double> speedPath = ship.get("speed");
        Path<Double> ratingPath = ship.get("rating");
        Path<ShipType> shipTypePath = ship.get("shipType");
        Path<Boolean> isUsedPath = ship.get("isUsed");

        List<Predicate> predicates = new ArrayList<>();
        if (nonNull(name)) {
            predicates.add(cb.like(namePath, "%" + name + "%"));
        }
        if (nonNull(planet)) {
            predicates.add(cb.like(planetPath, planet));
        }
        if (nonNull(after) && nonNull(before)) {
            predicates.add(cb.between(yearPath, after, before));
        }

        if (nonNull(minCrewSize) && nonNull(maxCrewSize)) {
            predicates.add(cb.between(crewSizePath, minCrewSize, maxCrewSize));
        }

        if (nonNull(minSpeed) && nonNull(maxSpeed)) {
            predicates.add(cb.between(speedPath, minSpeed, maxSpeed));
        }

        if (nonNull(minRating) && nonNull(maxRating)) {
            predicates.add(cb.between(ratingPath, minRating, maxRating));
        }

        if (nonNull(shipType)) {
            predicates.add((cb.equal(shipTypePath, shipType)));
        }

        if (nonNull(isUsed)) {
            predicates.add((cb.equal(isUsedPath, isUsed)));
        }


        query.select(cb.count(ship)).where(cb.and(predicates.
                toArray(new Predicate[predicates.size()])));
        return entityManager.createQuery(query).getSingleResult();
    }


}
