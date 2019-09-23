package com.space.service;

import com.space.exceptions.InCorrectFieldException;
import com.space.model.Ship;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShipChecker {

   private static double rating = 0.0;
   private static SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    private static Date date1;
    private static Date date2 ;
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

    public ShipChecker() throws ParseException {
    }

    public static void checkShip(Ship ship) throws InCorrectFieldException,  {


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

        if(ship.getProdDate().before(date1) && ship.getProdDate().after(date2)) {
            throw new InCorrectFieldException();
        }
        if(ship.getSpeed()==null  || (ship.getSpeed()<0.01 && ship.getSpeed()>0.99 )){
            throw new InCorrectFieldException();
        }
        if(ship.getCrewSize()==null  || (ship.getCrewSize()<1 && ship.getSpeed()>9999) ){
            throw new InCorrectFieldException();
        }



    }
    public static void shipRating(Ship ship){
        rating = (80*ship.getSpeed()*(ship.getUsed()?0.5:1))/
                ((date3).getYear()-ship.getProdDate().getYear())+1;
        rating=Math.round(rating*100.0)/100.0;
        ship.setRating(rating);
    }

    public static void checkId (Long id) throws InCorrectFieldException {
        if(id<1){
            throw new InCorrectFieldException();
        }
    }




}
