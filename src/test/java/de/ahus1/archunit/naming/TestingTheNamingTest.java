package de.ahus1.archunit.naming;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestingTheNamingTest {

  @Test
  public void shouldFindViolationsForModifying() {
    JavaClasses importedClasses = new ClassFileImporter().importPackages("de.ahus1.archunit.naming.violation");
    ArchRule rule = new NamingArchUnitTest().configurationsShouldBeNamedConfiguration;

    Assertions.assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> {
      rule.check(importedClasses);
    })
        .withMessageContaining("classes that are annotated with @Configuration should have name matching '.*Configuration'")
        .withMessageContaining("(1 times)");
  }

}
