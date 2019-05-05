package de.ahus1.archunit.structure;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition;

@AnalyzeClasses(packages = "de.ahus1.archunit.structure", importOptions = ImportOption.DoNotIncludeTests.class)
public class StructureArchUnitTest {

  @ArchTest
  public final ArchRule adaptersShouldNotDependOnEachOther =
      SlicesRuleDefinition.slices().matching("..adapter.(**)").should().notDependOnEachOther();

  @ArchTest
  public final ArchRule onionArchitecture =
      Architectures.layeredArchitecture()
          .layer("adapter").definedBy("..adapter..")
          .layer("domain").definedBy("..domain..")
          .layer("application").definedBy("..application..")
          .whereLayer("adapter").mayNotBeAccessedByAnyLayer()
          .whereLayer("application").mayOnlyBeAccessedByLayers("adapter");

}
