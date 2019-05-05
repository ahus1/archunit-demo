package de.ahus1.archunit.springdata;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RepositoryWithBulkOperation extends CrudRepository<Ship, Long> {

  @Modifying(clearAutomatically = true, flushAutomatically = true)
  @Query("delete from Ship s where s.type = ?1")
  void deleteInBulkByType(String type);

}
