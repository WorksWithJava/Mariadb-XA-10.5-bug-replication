package ca.usherbrooke.veo.xastresstester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class XaStressTester {
  public static void main(String[] args) {
    SpringApplication.run(XaStressTester.class, args);
  }
}
