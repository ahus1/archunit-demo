package de.ahus1.archunit.springdata;

import com.tngtech.archunit.core.domain.JavaMember;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.springframework.data.jpa.repository.Modifying;

@AnalyzeClasses(packages = "de.ahus1.archunit.springdata", importOptions = ImportOption.DoNotIncludeTests.class)
public class JpaArchUnitTest {


  private ArchCondition<? super JavaMember> HAVE_MODIFYING_PARAMETERS_SET =
      new ArchCondition<JavaMember>("have clearAutomatically/flushAutomatically set") {
        @Override
        public void check(JavaMember javaMember, ConditionEvents events) {
          Modifying annotationOfType = javaMember.getAnnotationOfType(Modifying.class);
          if (annotationOfType != null) {
            if (!annotationOfType.clearAutomatically()) {
              String message = String.format(
                  "clearAutomatically is not set to true on %s", javaMember.getFullName());
              events.add(SimpleConditionEvent.violated(javaMember, message));
            }
            if (!annotationOfType.flushAutomatically()) {
              String message = String.format(
                  "flushAutomatically is not set to true on %s", javaMember.getFullName());
              events.add(SimpleConditionEvent.violated(javaMember, message));
            }
          }
        }
      };

  @ArchTest
  public final ArchRule modifyingAnnotationnsShouldHavePropertiesSet =
      ArchRuleDefinition.members().that().areAnnotatedWith(Modifying.class)
          .should(HAVE_MODIFYING_PARAMETERS_SET)
          .because("so they will flush the persistence context and data will not be found using the ID");

}
