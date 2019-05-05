package de.ahus1.archunit.logging;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestingTheLoggingTest {

  @Test
  public void shouldFindViolationsForModifying() {
    JavaClasses importedClasses = new ClassFileImporter().importPackages("de.ahus1.archunit.logging.violation");
    ArchRule rule = new LoggingArchUnitTest().shouldNotAccessWarnAndErrorMethodsInLogger;

    Assertions.assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> {
      rule.check(importedClasses);
    })
        .withMessageContaining("no classes should call code unit where target matches 'org.apache.logging.log4j.Logger.(warn|error)\\(.*\\)'")
        .withMessageContaining("(1 times)");
  }

}
