package de.ahus1.archunit.structure.adapter.rest;

import de.ahus1.archunit.structure.application.ApplicationFacade;
import de.ahus1.archunit.structure.domain.Ship;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipEndpoint {
  private final ApplicationFacade application;

  public ShipEndpoint(ApplicationFacade application) {
    this.application = application;
  }

  // running via http://localhost:8080/ship?name=hi
  @RequestMapping("/ship")
  public void newShip(@RequestParam(value = "name", required = true) String name) {
    application.newShip(Ship.builder().name(name).build());
  }
}
