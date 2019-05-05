package de.ahus1.archunit.structure.adapter.persistence;

import de.ahus1.archunit.structure.domain.Ship;
import de.ahus1.archunit.structure.domain.ShipRepository;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import static org.apache.logging.log4j.LogManager.getLogger;

@Component
public class ShipRepositoryImpl implements ShipRepository {

  private static final Logger log = getLogger(ShipRepositoryImpl.class);

  @Override
  public void storeShip(Ship ship) {
    log.warn("storing ship information {}", ship);
    // TODO
  }
}
