package com.space.service;

import com.space.exceptions.InCorrectFieldException;
import com.space.model.Ship;
import java.util.Date;

public class ShipChecker {

   private static double rating = 0.0;

    public static void checkShip(Ship ship) throws InCorrectFieldException {

        if(ship.getId()<=0  || ship.getId()==(long)ship.getId()){
            throw new InCorrectFieldException();
        }

        if(ship.getName()==null || ship.getName().isEmpty() || ship.getName().length()>50){
            throw new InCorrectFieldException();
        }
        if(ship.getPlanet()==null || ship.getPlanet().isEmpty() || ship.getPlanet().length()>50){
            throw new InCorrectFieldException();
        }
        if(ship.getShipType()==null){
            throw new InCorrectFieldException();
        }

        if(ship.getProdDate().before(new Date("01.01.2800")) && ship.getProdDate().before(new Date("01.01.3020"))) {
            throw new InCorrectFieldException();
        }
        if(ship.getSpeed()==0.0  || (ship.getSpeed()<0.01 && ship.getSpeed()>0.99 )){
            throw new InCorrectFieldException();
        }
        if(ship.getCrewSize()==0  || (ship.getCrewSize()<1 && ship.getSpeed()>9999) ){
            throw new InCorrectFieldException();
        }



    }
    public static void shipRating(Ship ship){
        rating = (80*ship.getSpeed()*(ship.getUsed()?0.5:1))/
                (new Date("31.12.3019").getYear()-ship.getProdDate().getYear())+1;
        rating=Math.round(rating*100.0)/100.0;
        ship.setRating(rating);
    }

    public static void checkId (Long id) throws InCorrectFieldException {
        if(id<1){
            throw new InCorrectFieldException();
        }
    }




}
