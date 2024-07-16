package br.com.healthhelper.customer.domain.usecase;

import br.com.healthhelper.customer.domain.entity.User;
import br.com.healthhelper.customer.domain.gateway.RepositoryGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FindUserByIdUseCase {

    private RepositoryGateway repositoryGateway;

    public User execute(final UUID id) {

        return repositoryGateway.findById(id);
    }
}
