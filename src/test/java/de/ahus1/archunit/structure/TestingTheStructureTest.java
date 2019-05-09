package de.ahus1.archunit.structure;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestingTheStructureTest {

  @Test
  public void shouldFindViolationsForAdapterStructure() {
    JavaClasses importedClasses = new ClassFileImporter().importPackages("de.ahus1.archunit.structure.violation");
    ArchRule rule = new StructureArchUnitTest().adaptersShouldNotDependOnEachOther;

    Assertions.assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> {
      rule.check(importedClasses);
    })
        .withMessageContaining("slices matching '..adapter.(*)..' should not depend on each other")
        .withMessageContaining("(1 times)");
  }

  @Test
  public void shouldFindViolationsForOnionStructure() {
    JavaClasses importedClasses = new ClassFileImporter().importPackages("de.ahus1.archunit.structure.violation");
    ArchRule rule = new StructureArchUnitTest().onionArchitecture;

    Assertions.assertThatExceptionOfType(AssertionError.class).isThrownBy(() -> {
      rule.check(importedClasses);
    })
        .withMessageContaining("Layered architecture")
        .withMessageContaining("(2 times)");
  }
}
