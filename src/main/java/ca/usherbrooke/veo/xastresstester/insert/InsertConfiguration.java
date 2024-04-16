package ca.usherbrooke.veo.xastresstester.insert;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.FixedRateTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Profile("insert")
@Configuration
@RequiredArgsConstructor
public class InsertConfiguration implements SchedulingConfigurer {
  private final InsertService insertService;

  @Override
  public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    taskRegistrar.addFixedRateTask(
        new FixedRateTask(insertService::insert, 2000, 0));
  }
}
