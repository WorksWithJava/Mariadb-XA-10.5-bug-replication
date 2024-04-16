package ca.usherbrooke.veo.xastresstester.delete;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.FixedRateTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Profile("delete")
@Configuration
@RequiredArgsConstructor
public class DeleteConfiguration implements SchedulingConfigurer {
  private final DeleteService deleteService;

  @Override
  public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    taskRegistrar.addFixedRateTask(
        new FixedRateTask(deleteService::delete, 2000, 0));
  }
}
