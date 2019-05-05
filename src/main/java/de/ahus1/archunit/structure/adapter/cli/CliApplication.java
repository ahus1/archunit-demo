package de.ahus1.archunit.structure.adapter.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("de.ahus1.archunit.structure")
public class CliApplication {
  public static void main(String[] args) {
    SpringApplication.run(CliApplication.class, args);
  }
}
