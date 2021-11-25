package C02_4.SIBUSINESS.repository;

import C02_4.SIBUSINESS.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDB extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
    UserModel findByUuid(String uuid);
}
