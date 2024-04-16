package ca.usherbrooke.veo.xastresstester.insert;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Profile("insert")
@Service
@RequiredArgsConstructor
@Slf4j
public class InsertService {
  private final InsertMapper insertMapper;
  private final TransactionTemplate transactionTemplate;
  private final JmsTemplate jmsTemplate;
  private final AtomicInteger invocationCounter = new AtomicInteger(0);

  public void insert() {
    log.debug("insert invoked");

    transactionTemplate.executeWithoutResult(status -> {
      insertMapper.insert(invocationCounter.getAndIncrement());

      jmsTemplate.send(session -> session.createTextMessage("insert"));
    });
  }
}
