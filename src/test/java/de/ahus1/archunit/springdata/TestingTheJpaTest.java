package de.ahus1.archunit.springdata;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestingTheJpaTest {

  @Test
  public void shouldFindViolationsForModifying() {
    JavaClasses importedClasses = new ClassFileImporter().importPackages("de.ahus1.archunit.springdata.violation");
    ArchRule rule = new JpaArchUnitTest().modifyingAnnotationnsShouldHavePropertiesSet;

    Assertions.assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> {
      rule.check(importedClasses);
    })
        .withMessageContaining("@Modifying should have clearAutomatically/flushAutomatically")
        .withMessageContaining("(2 times)");
  }

}
