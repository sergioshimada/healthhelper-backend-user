package br.com.healthhelper.customer.domain.usecase;

import br.com.healthhelper.customer.domain.entity.User;
import br.com.healthhelper.customer.domain.gateway.RepositoryGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SaveUserUseCase {

    private RepositoryGateway repositoryGateway;

    public void execute(final User user) {

        repositoryGateway.save(user);
        log.info("save user with success userId: {}", user.getId());
    }
}
