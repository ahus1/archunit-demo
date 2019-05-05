package de.ahus1.archunit.springdata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class RepositoryWithBulkOperationTest {

  @Autowired
  private RepositoryWithBulkOperation repository;

  @Test
  public void shouldCreateEntity() {
    // given...
    Ship ship = Ship.builder().name("Enterprise").type("startrek").build();

    // when...
    repository.save(ship);

    // then...
    Assertions.assertThat(ship.getId()).isNotNull();
  }

  @Test
  public void shouldDeleteEntity() {
    // given...
    repository.deleteAll();
    Ship ship = Ship.builder().name("Enterprise").type("startrek").build();
    repository.save(ship);

    // when...
    repository.delete(ship);

    // then...
    Assertions.assertThat(repository.findById(ship.getId())).isEmpty();
    Assertions.assertThat(repository.findAll()).isEmpty();
  }


  @Test
  public void shouldBulkDelete() {
    // given...
    repository.deleteAll();
    Ship ship = Ship.builder().name("Enterprise").type("startrek").build();
    repository.save(ship);

    // when...
    repository.deleteInBulkByType("startrek");

    // then...
    Assertions.assertThat(repository.findById(ship.getId())).isEmpty();
  }
}
