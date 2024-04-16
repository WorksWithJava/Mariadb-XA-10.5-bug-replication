package ca.usherbrooke.veo.xastresstester.delete;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Profile("delete")
@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteService {
  private final DeleteMapper deleteMapper;
  private final TransactionTemplate transactionTemplate;
  private final JmsTemplate jmsTemplate;

  public void delete() {
    log.debug("delete invoked");

    transactionTemplate.executeWithoutResult(status -> {
      deleteMapper.delete();

      jmsTemplate.send(session -> session.createTextMessage("delete"));
    });
  }
}
