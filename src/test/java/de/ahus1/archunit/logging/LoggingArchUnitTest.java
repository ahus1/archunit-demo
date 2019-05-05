package de.ahus1.archunit.logging;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.properties.HasName;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import com.tngtech.archunit.library.GeneralCodingRules;

import static com.tngtech.archunit.core.domain.JavaCall.Predicates.target;
import static com.tngtech.archunit.lang.conditions.ArchConditions.callCodeUnitWhere;
import static de.ahus1.archunit.logging.LoggingArchUnitTest.FullNameMatchPredicate.fullNameMatches;

@AnalyzeClasses(packages = "de.ahus1.archunit.logging", importOptions = ImportOption.DoNotIncludeTests.class)
public class LoggingArchUnitTest {

  @ArchTest
  public ArchRule shouldNotUseJavaUtilLogging = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING
      .because("we use log4j2");

  @ArchTest
  public final ArchRule shouldNotAccessWarnAndErrorMethodsInLogger =
      ArchRuleDefinition.noClasses()
          .should(
              callCodeUnitWhere(
                  target(
                      fullNameMatches("org.apache.logging.log4j.Logger.(warn|error)\\(.*\\)")
                  )
              )
          )
          .because("you should have a central library that also assigns error and warning codes to the messages");

  public static class FullNameMatchPredicate<T extends HasName.AndFullName> extends DescribedPredicate<T> {
    private final String value;

    public FullNameMatchPredicate(String value) {
      super("matches '%s'", value);
      this.value = value;
    }

    @Override
    public boolean apply(HasName.AndFullName input) {
      return input.getFullName().matches(value);
    }

    public static <X extends HasName.AndFullName> FullNameMatchPredicate<X> fullNameMatches(String value) {
      return new FullNameMatchPredicate<X>(value);
    }
  }


}
