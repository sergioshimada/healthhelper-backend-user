package br.com.healthhelper.customer.domain.usecase;

import br.com.healthhelper.customer.domain.entity.User;
import br.com.healthhelper.customer.domain.gateway.RepositoryGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class DeleteUserByIdUseCase {

    private RepositoryGateway repositoryGateway;
    private FindUserByIdUseCase findUserByIdUseCase;

    public void execute(final UUID id) {

        User user = findUserByIdUseCase.execute(id);

        repositoryGateway.delete(user);
        log.info("user deleted with success, userId: {}", id);
    }
}
