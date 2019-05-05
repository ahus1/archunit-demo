package de.ahus1.archunit.structure.application;

import de.ahus1.archunit.structure.domain.Ship;
import de.ahus1.archunit.structure.domain.ShipRepository;
import org.springframework.stereotype.Component;

@Component
public class ApplicationFacade {
  private final ShipRepository shipRepository;

  public ApplicationFacade(ShipRepository shipRepository) {
    this.shipRepository = shipRepository;
  }

  public void newShip(Ship ship) {
    shipRepository.storeShip(ship);
  }
}
