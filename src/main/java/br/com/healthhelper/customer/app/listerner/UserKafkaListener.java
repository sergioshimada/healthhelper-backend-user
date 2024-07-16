package br.com.healthhelper.customer.app.listerner;

import br.com.healthhelper.customer.app.listerner.dto.CreateUserMessage;
import br.com.healthhelper.customer.app.mapper.UserAppMapper;
import br.com.healthhelper.customer.domain.usecase.SaveUserUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class UserKafkaListener {

    private SaveUserUseCase saveUserUseCase;
    private UserAppMapper userAppMapper;

    @KafkaListener(topics = "${topic.create.user}")
    @RetryableTopic(
            backoff = @Backoff(value = 5000L),
            attempts = "5",
            exclude = NullPointerException.class)
    public void consume(@Payload String value, Acknowledgment ack) throws JsonProcessingException {

        CreateUserMessage createUserMessage = new ObjectMapper().readValue(value, CreateUserMessage.class);
        log.info("process start to save user: {}", createUserMessage.getId());
        saveUserUseCase.execute(userAppMapper.requestToDomain(createUserMessage));
        log.info("process end with success to save user: {}", createUserMessage.getId());
        ack.acknowledge();
    }
}
