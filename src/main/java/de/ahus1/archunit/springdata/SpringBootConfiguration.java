package de.ahus1.archunit.springdata;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "de.ahus1.archunit.springdata")
public class SpringBootConfiguration {
}
