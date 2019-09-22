package com.space.repository;

import com.space.model.Ship;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class ShipCustomRepositoryImpl implements ShipCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ship> findByFilter(Integer pageNumber, Integer pageSize, String name, String planet) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ship> query = cb.createQuery(Ship.class);
        Root<Ship> ship = query.from(Ship.class);
        Path<String> namePath = ship.get("name");
        Path<String> planetPath = ship.get("planet");

        List<Predicate> predicates = new ArrayList<>();
        if (nonNull(name)) {
            predicates.add(cb.like(namePath, "%" + name + "%"));
        }
        if (nonNull(planet)) {
            predicates.add(cb.like(planetPath, planet));
        }

        query.select(ship).where(cb.and(predicates.toArray(new Predicate[predicates.size()]))).orderBy(cb.asc(ship.get("planet")));

        return entityManager.createQuery(query).setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }
}
