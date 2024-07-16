package br.com.healthhelper.customer.domain.gateway;

import br.com.healthhelper.customer.domain.entity.User;

import java.util.UUID;

public interface RepositoryGateway {

    void save(User user);
    User findById(UUID id);
    void delete(User user);
}
