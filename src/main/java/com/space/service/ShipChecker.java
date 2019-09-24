package com.space.service;

import com.space.exceptions.InCorrectFieldException;
import com.space.model.Ship;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.Objects.nonNull;

public class ShipChecker {

    private static double rating = 0.0;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    private static Date date1;
    private static Date date2;
    private static Date date3;

    static {
        try {

            date1 = simpleDateFormat.parse("01/01/2800 00:00:00");
            date2 = simpleDateFormat.parse("01/01/3020 00:00:00");
            date3 = simpleDateFormat.parse("01/01/3019 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public ShipChecker() {
    }

    public static void checkShip(Ship ship) throws InCorrectFieldException {


//        if(ship.getId()<=0  || ship.getId()==(long)ship.getId()){
//            throw new InCorrectFieldException();
//        }

        if (ship.getName() == null || ship.getName().isEmpty() || ship.getName().length() > 50) {
            throw new InCorrectFieldException();
        }
        if (ship.getPlanet() == null || ship.getPlanet().isEmpty() || ship.getPlanet().length() > 50) {
            throw new InCorrectFieldException();
        }
        if (ship.getShipType() == null) {
            throw new InCorrectFieldException();
        }
        if (ship.getUsed() == null) {
            ship.setUsed(false);
        }

        if (ship.getProdDate().before(date1) || ship.getProdDate().after(date2)) {
            throw new InCorrectFieldException();
        }
        if (ship.getSpeed() == null || ship.getSpeed() < 0.01 || ship.getSpeed() > 0.99) {
            throw new InCorrectFieldException();
        }
        if (ship.getCrewSize() == null || ship.getCrewSize() < 1 || ship.getCrewSize() > 9999) {
            throw new InCorrectFieldException();
        }


    }

    public static void shipRating(Ship ship) {
        Double sp = ship.getSpeed();
        int ye = date3.getYear();
        int ye1 = ship.getProdDate().getYear();

        rating = (80 * sp * (ship.getUsed() ? 0.5 : 1)) /
                ((ye - ye1) + 1);
        rating = Math.round(rating * 100.0) / 100.0;
        ship.setRating(rating);
    }

    public static void checkId(Long id) throws InCorrectFieldException {
        if (id == null || id < 1) {
            throw new InCorrectFieldException();
        }
    }

    public static boolean updateShipData(Ship oldShip, Ship newShip) throws InCorrectFieldException {
        boolean isUpdated = false;
        if (nonNull(newShip.getName())) {
            oldShip.setName(newShip.getName());
            isUpdated = true;
        }
        if (nonNull(newShip.getPlanet())) {
            oldShip.setPlanet(newShip.getPlanet());
            isUpdated = true;
        }
        if (nonNull(newShip.getProdDate())) {
            oldShip.setProdDate(newShip.getProdDate());
            isUpdated = true;
        }
        if (nonNull(newShip.getShipType())) {
            oldShip.setShipType(newShip.getShipType());
            isUpdated = true;
        }
        if (nonNull(newShip.getSpeed())) {
            oldShip.setSpeed(newShip.getSpeed());
            isUpdated = true;
        }
        if (nonNull(newShip.getUsed())) {
            oldShip.setUsed(newShip.getUsed());
            isUpdated = true;
        }
        if (nonNull(newShip.getCrewSize())) {
            oldShip.setCrewSize(newShip.getCrewSize());
            isUpdated = true;
        }
        if (nonNull(newShip.getRating())) {
            oldShip.setRating(newShip.getRating());
            isUpdated = true;
        }
        return isUpdated;

    }


}
