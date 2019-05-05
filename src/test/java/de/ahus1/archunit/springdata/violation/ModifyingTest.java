package de.ahus1.archunit.springdata.violation;

import org.springframework.data.jpa.repository.Modifying;

public interface ModifyingTest {
  @Modifying
  void testMethod();
}
