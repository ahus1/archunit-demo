package de.ahus1.archunit.structure.domain;

public class Ship {
  private String name;

  Ship(String name) {
    this.name = name;
  }

  public static ShipBuilder builder() {
    return new ShipBuilder();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static class ShipBuilder {
    private String name;

    ShipBuilder() {
    }

    public Ship.ShipBuilder name(String name) {
      this.name = name;
      return this;
    }

    public Ship build() {
      return new Ship(name);
    }

    public String toString() {
      return "Ship.ShipBuilder(name=" + this.name + ")";
    }
  }
}
