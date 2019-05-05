package de.ahus1.archunit.logging;

import org.apache.logging.log4j.Logger;

import static org.apache.logging.log4j.LogManager.getLogger;

public class ClassWithLogging {
  private static final Logger log = getLogger(ClassWithLogging.class);

  public void test() {
    log.info("hi");
    // log.warn("hi");
  }
}
