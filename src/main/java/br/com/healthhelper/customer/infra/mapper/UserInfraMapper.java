package br.com.healthhelper.customer.infra.mapper;

import br.com.healthhelper.customer.domain.entity.User;
import br.com.healthhelper.customer.infra.dataprovider.db.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInfraMapper {

    User modelToDomain(UserModel model);
    UserModel domainToModel(User domain);
}
