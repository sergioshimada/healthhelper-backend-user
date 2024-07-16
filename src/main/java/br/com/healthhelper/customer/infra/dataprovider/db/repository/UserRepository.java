package br.com.healthhelper.customer.infra.dataprovider.db.repository;

import br.com.healthhelper.customer.infra.dataprovider.db.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID>  {

}
