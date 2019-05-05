package de.ahus1.archunit.naming;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.context.annotation.Configuration;

@AnalyzeClasses(packages = "de.ahus1.archunit.naming", importOptions = ImportOption.DoNotIncludeTests.class)
public class NamingArchUnitTest {

  @ArchTest
  public final ArchRule configurationsShouldBeNamedConfiguration =
      ArchRuleDefinition.classes().that().areAnnotatedWith(Configuration.class)
          .should().haveNameMatching(".*Configuration");

}
