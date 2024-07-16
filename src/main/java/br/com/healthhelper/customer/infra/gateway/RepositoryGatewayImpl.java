package br.com.healthhelper.customer.infra.gateway;

import br.com.healthhelper.customer.domain.entity.User;
import br.com.healthhelper.customer.domain.exception.UserNotFoundException;
import br.com.healthhelper.customer.domain.gateway.RepositoryGateway;
import br.com.healthhelper.customer.infra.dataprovider.db.model.UserModel;
import br.com.healthhelper.customer.infra.dataprovider.db.repository.UserRepository;
import br.com.healthhelper.customer.infra.mapper.UserInfraMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class RepositoryGatewayImpl implements RepositoryGateway {

    private UserInfraMapper userInfraMapper;
    private UserRepository userRepository;

    @Override
    public void save(User user) {

        log.info("repository gateway processed to save user");
        userRepository.save(userInfraMapper.domainToModel(user));
    }

    @Override
    public User findById(UUID id) {
        log.info("repository gateway find user");
        Optional<UserModel> userModel = userRepository.findById(id);
        if (userModel.isPresent()){
            return userInfraMapper.modelToDomain(userModel.get());
        }
        else{
            throw new UserNotFoundException();
        }
    }

    @Override
    public void delete(User user) {
        log.info("repository gateway delete user");
        userRepository.delete(userInfraMapper.domainToModel(user));
    }
}
