package br.com.healthhelper.customer.app.mapper;

import br.com.healthhelper.customer.app.dto.request.UserRequest;
import br.com.healthhelper.customer.app.dto.response.UserResponse;
import br.com.healthhelper.customer.app.listerner.dto.CreateUserMessage;
import br.com.healthhelper.customer.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserAppMapper {

    UserResponse domainToResponse(User domain);
    User requestToDomain(UserRequest request);
    User requestToDomain(CreateUserMessage message);
}
