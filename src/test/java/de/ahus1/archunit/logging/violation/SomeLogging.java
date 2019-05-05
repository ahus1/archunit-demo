package de.ahus1.archunit.logging.violation;

import org.apache.logging.log4j.Logger;

import static org.apache.logging.log4j.LogManager.getLogger;

public class SomeLogging {
  private static final Logger log = getLogger(SomeLogging.class);

  public void test() {
    log.warn("hi");
  }
}
