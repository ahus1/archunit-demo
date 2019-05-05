package de.ahus1.archunit.springdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ship {
  @Id
  @GeneratedValue
  private Long id;
  private String type;
  private String name;

  Ship(Long id, String type, String name) {
    this.id = id;
    this.type = type;
    this.name = name;
  }

  public static ShipBuilder builder() {
    return new ShipBuilder();
  }

  public Long getId() {
    return this.id;
  }

  public String getType() {
    return this.type;
  }

  public String getName() {
    return this.name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static class ShipBuilder {
    private Long id;
    private String type;
    private String name;

    ShipBuilder() {
    }

    public Ship.ShipBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public Ship.ShipBuilder type(String type) {
      this.type = type;
      return this;
    }

    public Ship.ShipBuilder name(String name) {
      this.name = name;
      return this;
    }

    public Ship build() {
      return new Ship(id, type, name);
    }

  }
}
