package com.space.controller;


import com.space.exceptions.InCorrectFieldException;
import com.space.model.Ship;
import com.space.model.ShipType;
import com.space.service.ShipChecker;
import com.space.service.ShipServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ShipController {

    @Autowired
    private ShipServiceInterface shipService;


    @RequestMapping(value = "/rest/ships", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Ship> getShipList(@RequestParam(required = false) String name,
                           String planet, Long after, Long before, Integer minCrewSize,
                           Integer maxCrewSize, Double minSpeed, Double maxSpeed, Double minRating,
                           Double maxRating, ShipType shipType, Boolean isUsed,
                           @RequestParam(defaultValue = "0") Integer pageNumber,
                           @RequestParam(defaultValue = "3") Integer pageSize,
                           @RequestParam(defaultValue = "ID") String order) {
        switch (order){
            case  "ID":  order = "id";break;
            case  "SPEED": order = "speed";break;
            case  "DATE": order = "prodDate";break;
            case "RATING": order = "rating";break;
        }

        return shipService.getListShips(pageNumber, pageSize,order, name, planet,after,before,minCrewSize,maxCrewSize,minSpeed,maxSpeed,
                minRating,maxRating,shipType,isUsed);
    }

    @RequestMapping(value = "/rest/ships", method = RequestMethod.POST)
    public String addShip(@RequestBody Ship ship) {
       try {
           ShipChecker.checkShip(ship);
       }  catch (InCorrectFieldException e) { }
        ShipChecker.shipRating(ship);
        shipService.createShip(ship);
        return "redirect:/";
    }

    @RequestMapping(value = "/rest/ships/{id}", method = RequestMethod.DELETE)
    public String deleteShip(@PathVariable("id") Long id) {
        Ship ship = shipService.getShipById(id);
        shipService.delete(ship);
        return "redirect:/";
    }

    @RequestMapping(value = "/rest/ships/{id}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Ship updateShip(@RequestBody Ship ship) {
        try {
            ShipChecker.checkShip(ship);
        }  catch (InCorrectFieldException e) { }
        ShipChecker.shipRating(ship);
        shipService.updateShip(ship);
        return ship;
    }

    @RequestMapping(value = "rest/ships/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    Ship getShip(@PathVariable("id") Long id) {
        try {
            ShipChecker.checkId(id);
        } catch (InCorrectFieldException e) {
            e.printStackTrace();
        }
        return shipService.getShipById(id);
    }

    @RequestMapping(value = "rest/ships/count", produces = "application/json")
    public @ResponseBody
    int getShipsCount() {

        return shipService.getShipCount();
    }

}
